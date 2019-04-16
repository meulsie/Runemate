package com.meulsie.bots.vb_progress_woodcut.enums;

import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.local.Skills;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Tree {

    REGULAR("Tree",1),
    OAK("Oak",15),
    WILLOW("Willow",30),
    MAPLE("Maple",45),
    YEW("Yew",60),
    MAGIC("Magic",75);

    private String name;
    private int level;

    Tree(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public String getName() { return name; }
    public int getLevel() { return level; }

    public static List<Tree> getTreesForLevel() {
        return Arrays.stream(values()).filter(t -> t.level <= Skills.getLevel(Skill.WOODCUTTING)).collect(Collectors.toList());
    }

    public static Tree getBestTreeForLevel() {
        //return getTreesForLevel().stream().max(Comparator.comparingInt(t -> t.level)).orElse(REGULAR);
        List<Tree> trees = getTreesForLevel();
        return trees.isEmpty() ? REGULAR : trees.get(trees.size()-1);
    }
}