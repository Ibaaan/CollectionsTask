package ru.naumen.collection.task1;

import java.util.HashMap;
import java.util.Map;

/**
 * Дано:
 * <pre>
 * public class Ticket {
 *     private long id;
 *     private String client;
 *     …
 * }</pre>
 * <p>Разработать программу для бармена в холле огромного концертного зала.
 * Зрители в кассе покупают билет (класс Ticket), на котором указан идентификатор билета (id) и имя зрителя.
 * При этом, есть возможность докупить наборы разных товаров (комбо-обед): нет товаров, напитки, еда и напитки.
 * Доп. услуги оформляются через интернет и привязываются к билету, но хранятся отдельно от билета
 * (нельзя добавить товары в класс Ticket).</p>
 * <p>Бармен сканирует билет и получает объект Ticket. По этому объекту нужно уметь
 * находить необходимые товары по номеру билета. И делать это нужно очень быстро,
 * ведь нужно как можно быстрее всех накормить.</p>
 * <p>
 * См. {@link Ticket}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task1
{
    public enum Goods {
        /**
         * нет товаров
         */
        EMPTY,
        /**
         * напитки
         */
        DRINKS,
        /**
         * еда и напитки
         */
        FOOD_AND_DRINKS
    }

    Map<Long, Goods> ticketGoods = new HashMap<>();

    /**
     * Добавить билету товар
     */
    public void addToTicket(Ticket ticket, Goods good){
        ticketGoods.put(ticket.getId(), good);
    }

    /**
     * Получить товары по билету
     */
    public Goods getGoods(Ticket ticket) {
        return ticketGoods.getOrDefault(ticket.getId(), Goods.EMPTY);
    }
}
/*
Сложность - O(2n), где O(n) - прикрепление каждому билету товара,
                       О(n) - получение по id билета товара
Почему - Map позволяет хранить данные в виде отображения key -> value,
         HashMap позволяет добавить и удалить элемент за О(1)
 */