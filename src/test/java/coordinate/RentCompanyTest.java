package coordinate;

import coordinate.car.Avante;
import coordinate.car.K5;
import coordinate.car.Sonata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RentCompanyTest {

    private final String NEW_LINE = System.getProperty("line.separator");

    @ParameterizedTest
    @DisplayName("차량별 연료량을 확인할 수 있는 보고서")
    @CsvSource(value = {"100,20,30,26,130", "30,70,150,13,26"})
    void report(int sonataDistance, int sonataDistance2, int avanteDistance, int k5Distance, int k5Distance2) {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(sonataDistance));
        company.addCar(new Sonata(sonataDistance2));
        company.addCar(new Avante(avanteDistance));
        company.addCar(new K5(k5Distance));
        company.addCar(new K5(k5Distance2));
        assertThat(company.generateReport()).isEqualTo(
                "Sonata : " + sonataDistance / 10 + "리터" + NEW_LINE +
                        "Sonata : " + sonataDistance2 / 10 + "리터" + NEW_LINE +
                        "Avante : " + avanteDistance / 15 + "리터" + NEW_LINE +
                        "K5 : " + k5Distance / 13 + "리터" + NEW_LINE +
                        "K5 : " + k5Distance2 / 13 + "리터"
        );
    }
}
