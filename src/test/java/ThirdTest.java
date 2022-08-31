import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdTest extends BaseClass {
    Board newBoard;
    @BeforeMethod
    public void createNewBoardBeforeTests() throws JsonProcessingException {
        newBoard = TestSteps.createNewBoard(new Board(name, key, token));
    }

    @Test
    public void deleteBoardByIDTest() throws JsonProcessingException {
        int statusCode = TestSteps.deleteMyBoard(newBoard.getId());
        Assert.assertEquals(statusCode, 200);
    }
}
