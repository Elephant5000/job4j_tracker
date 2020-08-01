package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    private static List<Attachment> filter(List<Attachment> attachments, Predicate<Attachment> func){
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att: attachments){
            if (func.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> func = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() >= 100;
            }
        };
/*
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
 */
        return filter(list, func);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> func = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
/*
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
 */
        return filter(list, func);
    }
}