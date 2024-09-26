package Level;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class HeightMap {
    private static int average(int[] numbers) {
        int sum = 0;
        int total = numbers.length;
        for (int i = 0; i < total; i++) {
            sum += numbers[i];
        }
        return (sum / total);
    }
    public static int[][] generate(int scale, int roughness, int minHeight, int maxHeight) {
        int mapWidth = (int)Math.pow(2, scale) + 1;
        int mapHeight = (int)Math.pow(2, scale) + 1;
        int[][] heightMapArray = new int[mapHeight][mapWidth];
        int squareSize = (mapWidth - 1) / 2;
        int[] random = new int[2];
        random[0] = 0 - roughness;
        random[1] = 0 + roughness;

        //Set starting corners
        heightMapArray[0][0] = ThreadLocalRandom.current().nextInt(minHeight, maxHeight);
        heightMapArray[mapWidth - 1][0] = ThreadLocalRandom.current().nextInt(minHeight, mapHeight);
        heightMapArray[mapWidth - 1][mapHeight - 1] = ThreadLocalRandom.current().nextInt(minHeight, maxHeight);
        heightMapArray[0][mapHeight - 1] = ThreadLocalRandom.current().nextInt(minHeight, maxHeight);

        //Loop for every scale
        for (int currentScale = 0; currentScale < scale; currentScale++) {
            //Calculate middle for all squares
            for (int squareX = 0; squareX < (mapHeight - 1) / (squareSize * 2); squareX++) {
                for (int squareY = 0; squareY < (mapWidth - 1) / (squareSize * 2); squareY++) {
                    int[] topLeft = {squareX * squareSize * 2, squareY * squareSize * 2};
                    int[] topRight = {topLeft[0] + (squareSize * 2), topLeft[1]};
                    int[] bottomLeft = {topLeft[0], topLeft[1] + (squareSize * 2)};
                    int[] bottomRight = {bottomLeft[0] + (squareSize * 2), bottomLeft[1]};

                    int topLeftNum = heightMapArray[topLeft[0]][topLeft[1]];
                    int topRightNum = heightMapArray[topRight[0]][topRight[1]];
                    int bottomLeftNum = heightMapArray[bottomLeft[0]][bottomLeft[1]];
                    int bottomRightNum = heightMapArray[bottomRight[0]][bottomRight[1]];

                    int[] temp = {topLeftNum, topRightNum, bottomLeftNum, bottomRightNum};
                    int averageNum = average(temp);
                    //And roughness
                    averageNum += ThreadLocalRandom.current().nextInt(random[0], random[1]);

                    heightMapArray[topLeft[0] + squareSize][topLeft[1] + squareSize] = averageNum;
                }
            }
            for (int squareX = 0; squareX < (mapHeight - 1) / (squareSize * 2); squareX++) {
                for (int squareY = 0; squareY < (mapWidth - 1) / (squareSize * 2); squareY++) {
                    int[] topLeft = {squareX * squareSize * 2, squareY * squareSize * 2};
                    int[] topRight = {topLeft[0] + (squareSize * 2), topLeft[1]};
                    int[] bottomLeft = {topLeft[0], topLeft[1] + (squareSize * 2)};
                    int[] bottomRight = {bottomLeft[0] + (squareSize * 2), bottomLeft[1]};
                    int[] middle = {topLeft[0] + squareSize, topLeft[1] + squareSize};

                    int topLeftNum = heightMapArray[topLeft[0]][topLeft[1]];
                    int topRightNum = heightMapArray[topRight[0]][topRight[1]];
                    int bottomLeftNum = heightMapArray[bottomLeft[0]][bottomLeft[1]];
                    int bottomRightNum = heightMapArray[bottomRight[0]][bottomRight[1]];
                    int middleNum = heightMapArray[middle[0]][middle[1]];

                    //Get edges pos
                    int[] topEdge = {topLeft[0] + squareSize, topLeft[1]};
                    int[] rightEdge = {topRight[0], topRight[1], squareSize};
                    int[] bottomEdge = {bottomLeft[0] + squareSize, bottomLeft[1]};
                    int[] leftEdge = {topLeft[0], topLeft[1] + squareSize};

                    int topEdgeNum;
                    int rightEdgeNum;
                    int bottomEdgeNum;
                    int leftEdgeNum;
                    //above square
                    if (topLeft[1] - squareSize > 0) {
                        int[] aboveMiddle = {topLeft[0] + squareSize, topLeft[1] - squareSize};
                        int aboveMiddleNum = heightMapArray[aboveMiddle[0]][aboveMiddle[1]];
                        int[] temp = {aboveMiddleNum, topRightNum, middleNum, topLeftNum};
                        topEdgeNum = average(temp);
                    }
                    else {
                        int[] temp = {topRightNum, middleNum, topLeftNum};
                        topEdgeNum = average(temp);
                    }
                    //Right edge
                    if (topRight[0] + squareSize < heightMapArray[0].length - 1) {
                        int[] rightMiddle = {topRight[0] + squareSize, topRight[1] + squareSize};
                        int rightMiddleNum = heightMapArray[rightMiddle[0]][rightMiddle[1]];
                        int[] temp = {rightMiddleNum, middleNum, topRightNum, bottomRightNum};
                        rightEdgeNum = average(temp);
                    }
                    else {
                        int[] temp = {topRightNum, middleNum, bottomRightNum};
                        rightEdgeNum = average(temp);
                    }
                    //Bottom edge
                    if (bottomLeft[1] + squareSize < heightMapArray.length - 1) {
                        int[] bottomMiddle = {bottomLeft[0] + squareSize, bottomLeft[1] + squareSize};
                        int bottomMiddleNum = heightMapArray[bottomMiddle[0]][bottomMiddle[1]];
                        int[] temp = {bottomMiddleNum, middleNum, bottomRightNum, bottomLeftNum};
                        bottomEdgeNum = average(temp);
                    }
                    else {
                        int[] temp = {middleNum, bottomRightNum, bottomLeftNum};
                        bottomEdgeNum = average(temp);
                    }
                    //Left edge
                    if (topLeft[0] - squareSize > 0) {
                        int[] leftMiddle = {topLeft[0] - squareSize, topLeft[1] + squareSize};
                        int leftMiddleNum = heightMapArray[leftMiddle[0]][leftMiddle[1]];
                        int[] temp = {middleNum, leftMiddleNum, topLeftNum, bottomLeftNum};
                        leftEdgeNum = average(temp);
                    }
                    else {
                        int[] temp = {middleNum, topLeftNum, bottomLeftNum};
                        leftEdgeNum = average(temp);
                    }

                    //Apply roughness
                    topEdgeNum += ThreadLocalRandom.current().nextInt(random[0], random[1]);
                    rightEdgeNum += ThreadLocalRandom.current().nextInt(random[0], random[1]);
                    bottomEdgeNum += ThreadLocalRandom.current().nextInt(random[0], random[1]);
                    leftEdgeNum += ThreadLocalRandom.current().nextInt(random[0], random[1]);

                    //Add them to height map
                    heightMapArray[topEdge[0]][topEdge[1]] = topEdgeNum;
                    heightMapArray[rightEdge[0]][rightEdge[1]] = rightEdgeNum;
                    heightMapArray[bottomEdge[0]][bottomEdge[1]] = bottomEdgeNum;
                    heightMapArray[leftEdge[0]][leftEdge[1]] = leftEdgeNum;
                }
            }
            if (random[0] != -1) {
                random[0] = random[0] / 2;
                random[1] = random[1] / 2;
            }
            squareSize = squareSize / 2;
        }
        return(heightMapArray);
    }
}
