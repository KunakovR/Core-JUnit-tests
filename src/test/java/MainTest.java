import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class MainTest {

    @Test
    public void test() {
        // given:
         int[][] regional_teams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},{51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};

         int [] expected = {51, 45, 31, 31, 30, 24, 22, 20, 18, 17};

        // when:
         int [] result = Main.national_team(regional_teams);

        // then:
         Assertions.assertTrue(result.length == 10);

         Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testHamcrest(){
        // given:
        int[][] regional_teams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},{51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};

        int [] expected = {51, 45, 31, 31, 30, 24, 22, 20, 18, 17};

        // when:
        int [] result = Main.national_team(regional_teams);

        // then:
        arrayContaining(result, hasItem(51));


    }

}
