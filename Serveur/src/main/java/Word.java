import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Word {
    private String mots_choisie;
    private ArrayList<String> list_mots = new ArrayList<String>(
            //aider par chatGPT : https://chat.openai.com/share/80552f7c-28d1-47d4-8483-78b4584fe885
            Arrays.asList("Albedo", "Alhaitham", "Aloy", "Amber", "Kamisato Ayaka", "Kamisato Ayato", "Baizhu", "Barbara",
                    "Beidou", "Bennett", "Candace", "Chongyun", "Collei", "Cyno", "Dehya", "Diluc", "Diona",
                    "Dori", "Eula", "Faruzan", "Fischl", "Ganyu", "Gorou", "Shikanoin Heizou", "Hu Tao",
                    "Arataki Itto", "Jean", "Kaedehara Kazuha", "Kaeya", "Kaveh", "Keqing", "Klee",
                    "Kokomi Sangonomiya", "Kuki Shinobu", "Layla", "Lisa", "Mika", "Mona", "Nahida", "Nilou",
                    "Ningguang", "Noelle", "Nomade Scaramouche", "Qiqi", "Shogun Raiden", "Razor", "Rosalia",
                    "Kujou Sara", "Sayu", "Shenhe", "Sucrose", "Tartaglia", "Thomas", "Tighnari", "Venti",
                    "Voyageur Anemo", "Voyageur Geo", "Voyageur Electro","Voyageur Dendro", "Xiangling", "Xiao",
                    "Xingqiu", "Xinyan", "Yae Miko", "Yanfei", "Yaoyao", "Yelan", "Yoimiya", "Yun Jin", "Zhongli")
    );

    /**
     * Genere un mot aleatoire pour le jeu.
     * */
    public Word() {
        Random random = new Random();
        int max = list_mots.size();
        int choice = random.nextInt(max);
        mots_choisie = list_mots.get(choice).toLowerCase();
    }

    public String getMots_choisie() {return mots_choisie;}
}
