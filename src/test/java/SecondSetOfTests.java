import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondSetOfTests extends BaseClass{
    Board newBoard;
    @BeforeMethod
    public void createNewBoardBeforeTests() throws JsonProcessingException {
        newBoard = TestSteps.createNewBoard(new Board(name, key, token));
    }
    @AfterMethod
    public void deleteBoardAfterTest() throws JsonProcessingException {
        int statusCode = TestSteps.deleteMyBoard(newBoard.getId());
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void checkBoardTest() throws JsonProcessingException {
        Board expectedBoard = new Board(name, key, token);
        Board actualBoard = TestSteps.checkBoardInfo(newBoard.getId());
        Assert.assertEquals(actualBoard, expectedBoard);
    }
    @Test
    public void updateBoardTest() throws JsonProcessingException {
        Board expectedBoard = new Board("NewName", key, token);
        Board actualBoard = TestSteps.updateBoardInfo(newBoard.getId());
        Assert.assertEquals(actualBoard, expectedBoard);
        Assert.assertEquals(actualBoard.getName(), "NewName");

    }
}
