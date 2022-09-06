import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SecondSetOfTests extends BaseTest {
    Board newBoard;
    TestSteps testSteps = new TestSteps();
    @BeforeMethod
    public void createNewBoardBeforeTests() throws IOException {
        newBoard = testSteps.createNewBoard();
    }
    @AfterMethod
    public void deleteBoardAfterTest() throws IOException {
        testSteps.deleteMyBoard(newBoard.getId());
    }
    @Test
    public void readBoardInfoTest() throws IOException {
        testSteps.checkBoardInfo(newBoard.getId());
    }
    @Test
    public void updateBoardTest() throws IOException {
        testSteps.readBoardInfo(newBoard.getId());

    }
}
