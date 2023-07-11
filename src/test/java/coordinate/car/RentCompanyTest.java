package coordinate.car;

import coordinate.RentCompany;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RentCompanyTest {

    private final String NEW_LINE = System.getProperty("line.separator");

    @ParameterizedTest
    @CsvSource(value = {"10, 20, 15, 13, 26", "100, 200, 150, 130, 260"})
    void report(int sonataDistance, int sonataDistance2, int avanteDistance, int k5Distance, int k5Distance2) {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(sonataDistance));
        company.addCar(new Sonata(sonataDistance2));
        company.addCar(new Avante(avanteDistance));
        company.addCar(new K5(k5Distance));
        company.addCar(new K5(k5Distance2));

        String report = company.generateReport();

        assertThat(report).isEqualTo(
                "Sonata : " + sonataDistance / 10 + "리터" + NEW_LINE +
                        "Sonata : " + sonataDistance2 / 10 + "리터" + NEW_LINE +
                        "Avante : " + avanteDistance / 15 + "리터" + NEW_LINE +
                        "K5 : " + k5Distance / 13 + "리터" + NEW_LINE +
                        "K5 : " + k5Distance2 / 13 + "리터"
        );
    }
}
