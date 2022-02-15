package racingcar.model;

import racingcar.util.IntegerConst;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarList {
    private final ArrayList<Car> carList;

    public CarList(String[] names) {
        this.carList = new ArrayList<>();
        for (String eachName : names) {
            this.carList.add(new Car(eachName));
        }
    }

    public ArrayList<String> getNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Car car : this.carList) {
            nameList.add(car.getName());
        }
        return nameList;
    }

    public void moveCarAt(int index, int number) {
        this.carList.get(index).movePosition(number);
    }

    public int getMaxPosition() {
        int maxPosition = IntegerConst.ZERO.getValue();
        for (Car car : this.carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public ArrayList<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return (ArrayList<String>) this.carList.stream().filter(car -> car.isWinner(maxPosition)).map(Car::getName).collect(Collectors.toList());
    }

    public int getTotalCount() {
        return this.carList.size();
    }
}