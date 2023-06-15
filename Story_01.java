import java.util.Scanner;

public class Story_01 {

    private static Hero h;
    private static Monster sa;

    public static void s0(){
    System.out.println("あなたの名前を入力してください");
    Scanner scanner = new Scanner(System.in);
    String heroName = scanner.next();
    scanner.close();

     // 勇者を召喚
    h = new Hero("勇者"+heroName, 100, 100, 25, 30);

    System.out.println(h.name + "を生み出しました。");
    System.out.println("【最大ＨＰ】" + h.maxHp);
    System.out.println("【攻撃力】" + h.attack);
    System.out.println("【スピード】" + h.speed);

    System.out.println("Enterキーを押して次に進んでください");
        
    Scanner scanner0 = new Scanner(System.in);
    scanner0.nextLine(); // Enterキーが押されるまで待機
    scanner0.close();

    // 行き先を選ぶ
    System.out.println("どこへ向かおうか？");
    System.out.println("1:魔物の森 2:綺麗な川");
    
    boolean validInput01 = false; // 1か2を入力させるため

    while (!validInput01) {

        Scanner scanner2 = new Scanner(System.in);
        int choice02 = scanner2.nextInt(); // 入力を受け取る
        scanner2.close();

        switch (choice02) {
            case 1:
                s1_1();
                validInput01 = true; // 入力が正しい場合はvalidInput01をtrueに設定してループを終了
                break;
    
            case 2:
                s1_2();
                s1_1();
                validInput01 = true; // 入力が正しい場合はvalidInput01をtrueに設定してループを終了
                break;
    
            default:
                System.out.println("再度入力してください");
                break;
        }
    }
    
}

    public static void s1_1(){
    // スライムを召喚
    sa = new Monster("スライムA", 30, 5, 15);
    System.out.println(sa.name + "が現れた！");
    System.out.println("【戦闘開始】");

    System.out.println("Enterキーを押して次に進んでください");
        
    Scanner scanner0a = new Scanner(System.in);
    scanner0a.nextLine(); // Enterキーが押されるまで待機
    scanner0a.close();

    if(h.speed >= sa.speed) {
        System.out.println(h.name + "の行動");
        System.out.println("");

        boolean validInput02 = false; // 1か2を入力させるため

    while (!validInput02) {

        System.out.println("1:攻撃 2:逃げる");
        System.out.println("");

        Scanner scanner3 = new Scanner(System.in);
        int choice03 = scanner3.nextInt(); // 入力を受け取る
        scanner3.close();

        switch (choice03) {
            case 1: // 戦う場合
                System.out.println(h.name + "の攻撃");
                System.out.println("");
                sa.hp -= h.attack;
                System.out.println(sa.name + "に" + h.attack + "ダメージ");
                System.out.println("");
                if(sa.hp <= 0){
                    System.out.println(sa.name + "が倒れた");

                    System.out.println("Enterキーを押して次に進んでください");
                    scanner0a.nextLine(); // Enterキーが押されるまで待機

                    System.out.println(h.name + "は経験値を 10 獲得した！");
                    h.Experience(10);
                    


                    validInput02 = true; // 敵を倒すとtrueに設定してループを終了
                }else{
                    System.out.println(sa.name + "の残りHP" + sa.hp);
                    System.out.println(sa.name + "の攻撃をどう受ける？");
                    System.out.println("");

                    System.out.println("1:横に飛んで回避 2:後ろに飛んで回避");
                    System.out.println("");

                    boolean validInput3 = false; // 1か2を入力させるため

                    while(!validInput3) {

                    Scanner scanner4 = new Scanner(System.in);
                    int choice04 = scanner4.nextInt(); // 入力を受け取る
                    scanner4.close();


                    switch (choice04) {
                        case 1:
                        System.out.println(sa.name + "の攻撃をかわした！");
                        System.out.println("");
                        validInput3 = true;
                        break;

                        case 2:
                        System.out.println(sa.name + "の攻撃をくらった！");
                        h.hp -= sa.attack;
                        System.out.println(h.name + "の残りHP" + h.hp);
                        System.out.println("");
                        validInput3 = true;
                        break;

                        default:
                        System.out.println("再度入力してください");
                        break;
                    }

                    }
                    

                }
                break;
    
            case 2: // 逃げる場合
                validInput02 = true; // trueに設定してループを終了

                System.out.println(h.name + "は逃げ出した。");

                scanner0a.nextLine(); // Enterキーが押されるまで待機
                System.out.println("");
                break;
    
            default:
                System.out.println("再度入力してください");
                break;
        }
    }
    }

    }

    public static void s1_2(){
    //　釣りを始める
    System.out.println("川釣りをして魚をゲットした！");
    System.out.println(h.name + "の最大HPが 10 増えた！" );
    h.maxHp += 10;
    h.hp += 10;
    h.status();
    System.out.println("");
    System.out.println("魔物の森へ移動します");
    System.out.println("Enterキーを押して次に進んでください");
        
    Scanner scanner0b = new Scanner(System.in);
    scanner0b.nextLine(); // Enterキーが押されるまで待機
    scanner0b.close();
    System.out.println("");
    }

}