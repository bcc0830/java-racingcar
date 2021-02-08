package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        validateNonDuplicatedNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getMaxPositionByCars() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private void validateNonDuplicatedNames(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
    }
}