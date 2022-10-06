import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Timeout(value = 50000, unit = TimeUnit.MICROSECONDS)

public class MainTest {

    @Test
    @DisplayName("Тест на промежуточный массив при слиянии")
    public void successMiddleArray() {
        // given:
        int[] team = {45, 31, 24, 22, 20, 17, 14, 13, 12, 10};
        int[] regionalTeams = {31, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        int [] expected = {45, 31, 31, 24, 22, 20, 18, 17, 15, 14};
        // when:
        int [] result = Main.merge(team, regionalTeams);
        // then:
        Assertions.assertTrue(result.length == 10);
        Assertions.assertArrayEquals(expected, result);

    }

    @Test
    @DisplayName("Тест на получаемый массив")
    public void successFinalArray() {
        // given:
         int[][] regionalTeams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},{51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};
         int [] expected = {51, 45, 31, 31, 30, 24, 22, 20, 18, 17};
        // when:
         int [] result = Main.nationalTeam(regionalTeams);
        // then:
         Assertions.assertTrue(result.length == 10);
         Assertions.assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("Тест на проверку имеющегося элемента массива")
    @ValueSource(ints = {51, 17})
    public void testParameterized(int arg) {
        // given:
        int[][] regionalTeams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},{51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};
        // when:
        int [] result = Main.nationalTeam(regionalTeams);
        // then:
        Assertions.assertEquals(Arrays.stream(result).filter(x -> x == arg).findAny().getAsInt(), arg);
    }


//    @Test
//    public void testHamcrest(){
//        // given:
//        int[][] regional_teams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
//                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},{51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};
//
//        int [] expected = {51, 45, 31, 31, 30, 24, 22, 20, 18, 17};
//
//        // when:
//        int [] result = Main.national_team(regional_teams);
//
//        // then:
//        arrayContaining(result, hasItem(51));
//    }

}


