package Programmers.Lv_2.스킬트리_49993;

import java.util.*;
class Solution {

    Map<String, Integer> initialSkillCondition;
    public int solution(String skill, String[] skill_trees) {
        this.initialSkillCondition = new HashMap<>();
        int answer = 0;
        setInitialSkillCondition(skill);

        int size = skill_trees.length;
        for (String skillTree : skill_trees) {

            if(checkSkillTree(skillTree, skill)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean checkSkillTree(String skillTree, String skill) {

        int currentIndex = 0;
        int size = skillTree.length();
        for (int i = 0; i < size; i++) {
            String currentSkill = Character.toString(skillTree.charAt(i));
            if (initialSkillCondition.containsKey(currentSkill)) {
                int skillIndex = initialSkillCondition.get(currentSkill);
                if (skillIndex == currentIndex) {
                    currentIndex++;
                } else if (skillIndex > currentIndex) {
                    return false;
                }
            }
        }
        return true;

    }

    private void setInitialSkillCondition(String skill) {
        int skillSize = skill.length();
        for (int i = 0 ; i < skillSize; i++) {
            initialSkillCondition.put(Character.toString(skill.charAt(i)), i);
        }
    }
}
