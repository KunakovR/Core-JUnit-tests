public class Main {

    public static int[][] regional_teams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
            {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},{51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};

    public static void main(String[] args) {

        int [] national_team = national_team(regional_teams);
        for (int i = 0; i < national_team.length; i++){
            System.out.print(national_team[i] + " ");
        }

    }

    public static int[] national_team(int[][] regional_teams){
        int[] team = regional_teams[0];
        for (int i = 1; i < regional_teams.length; i++){
            team = merge(team, regional_teams[i]);
        }
        return team;
    }

    public static int[] merge(int[] team, int[] regional_teams){

        int a = 0;
        int b = 0;
        int c = 0;

        int[] top = new int[10];

        while (a < team.length || b < regional_teams.length) {
            if (c == 10){
                break;
            }
            if (a == team.length) {
                top[c] = regional_teams[b];
                b += 1;
            }
            else if (b == regional_teams.length){
                top[c] = team[a];
            }
            else if (team[a] >= regional_teams[b]){
                top[c] = team[a];
                a +=1;
            }
            else {
                top[c] = regional_teams[b];
                b +=1;
            }
            c +=1;
        }
        return top;
    }
}
