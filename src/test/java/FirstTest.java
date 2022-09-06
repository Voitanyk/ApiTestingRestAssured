import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTest extends BaseTest {
  TestSteps testSteps = new TestSteps();
    Board newBoard;
    @AfterMethod
    public void deleteBoardAfterTest() throws IOException {
    testSteps.deleteMyBoard(newBoard.getId());
}
    @Test
    public void createBoardTest() throws IOException {
        newBoard = testSteps.createNewBoard();
    }

}
