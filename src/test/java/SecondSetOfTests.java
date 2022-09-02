import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SecondSetOfTests extends Properties {
    Board newBoard;
    TestSteps testSteps = new TestSteps();
    Properties properties = new Properties();
    @BeforeMethod
    public void createNewBoardBeforeTests() throws IOException {
        newBoard = testSteps.createNewBoard();
    }
    @AfterMethod
    public void deleteBoardAfterTest() throws IOException {
        int statusCode = testSteps.deleteMyBoard(newBoard.getId());
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void checkBoardTest() throws IOException {
        Board expectedBoard = new Board(properties.getValue("name"), properties.getValue("key"), properties.getValue("token"));
        Board actualBoard = testSteps.checkBoardInfo(newBoard.getId());
        Assert.assertEquals(actualBoard, expectedBoard);
    }
    @Test
    public void updateBoardTest() throws IOException {
        Board expectedBoard = new Board(properties.getValue("newName"), properties.getValue("key"), properties.getValue("token"));
        Board actualBoard = testSteps.updateBoardInfo(newBoard.getId());
        Assert.assertEquals(actualBoard, expectedBoard);
        Assert.assertEquals(actualBoard.getName(), properties.getValue("newName"));

    }
}
