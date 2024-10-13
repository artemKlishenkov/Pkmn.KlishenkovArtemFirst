package ru.mirea.klishenkovai;

import java.util.Scanner;

public class PkmnApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла с расширением .txt: ");
        String fileName = scanner.nextLine();

        try {
            CardImport cardImport = new CardImport(fileName);
            Card card = cardImport.card;

            System.out.println("Имя покемона: " + card.getName());
            System.out.println("Стадия покемона: " + card.getPokemonStage());
            System.out.println("HP: " + card.getHp());
            System.out.println("Тип покемона: " + card.getPokemonType());
            System.out.println("Способности покемона:");

            for (AttackSkill attack : card.getSkills()) {
                System.out.println("- " + attack.getName() + " (Цена: " + attack.getCost() + ", Урон: " + attack.getDamage() + ")");
            }

            if (card.getEvolvesFrom() != null) {
                System.out.println("Эволюционирует из: " + card.getEvolvesFrom().getName());
            }
            if (card.getWeaknessType() != null) {
                System.out.println("Слабость: " + card.getWeaknessType());
            }
            if (card.getResistanceType() != null) {
                System.out.println("Сопротивление: " + card.getResistanceType());
            }
            System.out.println("Цена побега: " + card.getRetreatCost());
            System.out.println("Название сета: " + card.getGameSet());
            System.out.println("Отметка легальности: " + card.getRegulationMark());

            if (card.getPokemonOwner() != null) {
                System.out.println("Владелец карты: " + card.getPokemonOwner().getName());
            } else {
                System.out.println("Владелец карты: информация отсутствует");
            }

        } catch (Exception e) {
            System.err.println("Ошибка при импорте карточки: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
