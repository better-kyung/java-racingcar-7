package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = scanner.nextLine().split(",");

        Map<String, Integer> cars = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() <= 5) {
                cars.put(input[i], 0);
            } else {
                throw new IllegalArgumentException("자동차의 이름은 5문자를 넘을 수 없습니다.");
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            moveCar(cars);
            printResult(cars);
        }
    }

    private static void printResult(Map<String, Integer> cars) {
        for (String name : cars.keySet()) {
            System.out.println(name + " : " + "-".repeat(cars.get(name)));
        }
        System.out.println();
    }


    private static void moveCar(Map<String, Integer> cars) {
        for (String name : cars.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                Integer newValue = cars.getOrDefault(name, 0);
                cars.put(name, newValue + 1);
            }
        }
    }


}
