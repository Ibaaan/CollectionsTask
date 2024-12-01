package ru.naumen.collection.task2;

import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно реализовать метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task2
{
    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        Set<User> set = new HashSet<>(collA);
        List<User> result = new ArrayList<>();
        for(User user : collB){
            if(set.contains(user)){
                result.add(user);
            }
        }
        return result;
    }
}
/*
Сложность - О(n+m), где O(n) - создание HashSet из коллекции collA,
                        O(m) - итерирование коллекции collB
Почему - Set позволяет хранить множество неповторяющихся элементов,
         HashSet позволяет добавить элемент и узнать принадлежит ли элемент коллекции за O(1)
 */