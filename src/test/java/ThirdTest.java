import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ThirdTest extends BaseTest{
    Board newBoard;
    TestSteps testSteps = new TestSteps();
    @BeforeMethod
    public void createNewBoardBeforeTests() throws IOException {
        newBoard = testSteps.createNewBoard();
    }

    @Test
    public void deleteBoardByIDTest() throws IOException {
        testSteps.deleteMyBoard(newBoard.getId());
    }
}
