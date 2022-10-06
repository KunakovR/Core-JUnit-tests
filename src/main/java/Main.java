public class Main {

    public static int[][] regionalTeams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
            {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},{51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};

    public static void main(String[] args) {

        int [] nationalTeam = nationalTeam(regionalTeams);
        for (int i = 0; i < nationalTeam.length; i++){
            System.out.print(nationalTeam[i] + " ");
        }

    }

    public static int[] nationalTeam(int[][] regionalTeams){
        int[] team = regionalTeams[0];
        for (int i = 1; i < regionalTeams.length; i++){
            team = merge(team, regionalTeams[i]);
        }
        return team;
    }

    public static int[] merge(int[] team, int[] regionalTeams){

        int a = 0;
        int b = 0;
        int c = 0;
        //Счетчики

        int[] top = new int[10];

        while (a < team.length || b < regionalTeams.length) {
            if (c == 10){
                break;
            }
            if (a == team.length) {
                top[c] = regionalTeams[b];
                b += 1;
            }
            else if (b == regionalTeams.length){
                top[c] = team[a];
            }
            else if (team[a] >= regionalTeams[b]){
                top[c] = team[a];
                a +=1;
            }
            else {
                top[c] = regionalTeams[b];
                b +=1;
            }
            c +=1;
        }
        return top;
    }
}
