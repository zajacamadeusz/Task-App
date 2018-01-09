import lombok.AllArgsConstructor;
import lombok.Getter;

public class test {
    String imie;
    String nazwisko;

    public test(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
