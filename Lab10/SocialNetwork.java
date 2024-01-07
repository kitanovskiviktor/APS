package Lab10;

/*
You're given a social network where the name and surname are stored for each user. The friends of the users are also known.
Write an algorithm that, when given the names of two users finds the degree of separation between the users (i.e. the minimum number of users
to get from one to another user) in the social network.
The social network is represented as an unweighted graph using an adjacency list. The number of users is given in the first input line.
The second line contains the name of the first user, followed by the number of friends of the first user. In the next lines, the names of the friends of the
first user are listed.
The information for all users is given in the same way. The last two input lines contain the names of the 2 users that you should compute the degree of separation for.
*/

import java.util.*;

public class SocialNetwork {

    private static int razdelenostKorisnici(String korisnik1, String korisnik2) {

        if (korisnik1.equals(korisnik2)) {
            return 0;
        }

        Queue<String> redica = new LinkedList<>();
        Set<String> posetenJazol = new HashSet<>();
        Map<String, Integer> razdelenost = new HashMap<>();
        redica.add(korisnik1);
        posetenJazol.add(korisnik1);
        razdelenost.put(korisnik1, 0);

        while (!redica.isEmpty()) {

            String tekovenKorisnik = redica.poll();

            for (String friend : listaSosedstvo.get(tekovenKorisnik)) {
                if (!posetenJazol.contains(friend)) {
                    redica.add(friend);
                    posetenJazol.add(friend);
                    razdelenost.put(friend, razdelenost.get(tekovenKorisnik) + 1);
                    if (friend.equals(korisnik2)) {
                        return razdelenost.get(friend);
                    }
                }
            }
        }
        return 0;
    }

    private static Map<String, Set<String>> listaSosedstvo;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int brojKorisnici = scanner.nextInt();
        scanner.nextLine();
        listaSosedstvo = new HashMap<>();
        for (int i = 0; i < brojKorisnici; i++) {
            String[] korisnik = scanner.nextLine().split(" ", 2);
            String ime = korisnik[0] + " " + korisnik[1];
            int brojPrijateli = scanner.nextInt();
            scanner.nextLine();

            Set<String> prijateli = new HashSet<>();
            for (int j = 0; j < brojPrijateli; j++) {
                prijateli.add(scanner.nextLine());
            }
            listaSosedstvo.put(ime, prijateli);
        }

        String prvKorisnik = scanner.nextLine();
        String vtorKorisnik = scanner.nextLine();

        int razdelenost = razdelenostKorisnici(prvKorisnik, vtorKorisnik);

        System.out.println( + razdelenost);
    }
}
