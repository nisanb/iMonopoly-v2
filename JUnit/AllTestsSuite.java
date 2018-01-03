import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GameSummaryTest.class, PlayerSortingTest.class, QuestionTest.class,
		SellPropertyTest.class, updatePropertyStrengthTest.class, UT_Params.class, bailOutStateTest.class, jsonTest.class })
public class AllTestsSuite {

}
