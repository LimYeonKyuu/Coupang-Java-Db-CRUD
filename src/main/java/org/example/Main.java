package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CoupangController coupangController = new CoupangController();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner, coupangController);
                    break;
                case 2:
                    viewProducts(coupangController);
                    break;
                case 3:
                    viewProducts(coupangController);
                    updateProduct(scanner, coupangController);
                    break;
                case 4:
                    viewProducts(coupangController);
                    deleteProduct(scanner, coupangController);
                    break;
                case 5:
                    saveProduct(coupangController);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
        System.out.println("이용해주셔서 감사합니다.");
    }

    private static void printMenu() {
        System.out.println("\n--- 쿠팡 물류 관리 시스템 ---");
        System.out.println("1. 물품 추가");
        System.out.println("2. 물품 목록 보기");
        System.out.println("3. 물품 수정");
        System.out.println("4. 물품 삭제");
        System.out.println("5. 저장");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    private static void addProduct(Scanner scanner, CoupangController productController) {
        System.out.print("물품 이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("물품 가격을 입력하세요(정수): ");
        int price = scanner.nextInt();
        System.out.print("물품 재고를 입력하세요(정수): ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("물품 설명을 입력하세요: ");
        String description = scanner.nextLine();

        productController.addProduct(name, price, stock, description);
        System.out.println("물품이 성공적으로 추가되었습니다.");
    }

    private static void viewProducts(CoupangController productController) {
        productController.viewProducts();
    }

    private static void updateProduct(Scanner scanner, CoupangController productController) {
        System.out.print("수정할 물품의 인덱스를 입력하세요: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("새 물품 이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("새 물품 가격을 입력하세요(정수): ");
        int price = scanner.nextInt();
        System.out.print("새 물품 재고를 입력하세요(정수): ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("새 물품 설명을 입력하세요: ");
        String description = scanner.nextLine();

        productController.updateProduct(productId, name, price, stock, description);
        System.out.println("물품 정보가 성공적으로 수정되었습니다.");
    }

    private static void deleteProduct(Scanner scanner, CoupangController productController) {
        System.out.print("삭제할 물품 ID를 입력하세요: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        productController.deleteProduct(productId);
        System.out.println("성공적으로 삭제되었습니다.");
    }
    private static void saveProduct(CoupangController coupangController) {
        coupangController.saveProducts();
        System.out.println("저장이 완료되었습니다.");
    }
}