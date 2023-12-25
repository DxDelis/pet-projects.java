package com.example.project2d;

        import java.net.URL;
        import java.util.ResourceBundle;

        import javafx.animation.*;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.image.ImageView;
        import javafx.util.Duration;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView bg1,bg2,player,enemy;

    @FXML
    private Label labelPause, labelLose;

    private final int BG_WIDTH = 713;
    private ParallelTransition parallelTransition;
    private TranslateTransition enemyTransition;

    public static boolean jump = false;

    public static boolean right = false;
    public static boolean left = false;
    public static boolean iSPause = false;

    private int playerSpeed = 3, jumpDownSpeed = 5;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {

            if (jump && player.getLayoutY() > 90f)
                player.setLayoutY(player.getLayoutY() - playerSpeed);
            else if (player.getLayoutY() <= 181f) {
                jump = false;
                player.setLayoutY(player.getLayoutY() + jumpDownSpeed);
            }

            if (right && player.getLayoutX() < 100f)
                player.setLayoutX(player.getLayoutX() + playerSpeed);//меняем координату по х по горизонтали
            if (left && player.getLayoutX() > 28f)
                player.setLayoutX(player.getLayoutX() - playerSpeed);

            if (iSPause && !labelPause.isVisible()){
                playerSpeed = 0;
                jumpDownSpeed = 0;
                parallelTransition.pause();
                enemyTransition.pause();
                labelPause.setVisible(true);
            }
            else if(!iSPause && labelPause.isVisible()){
                labelPause.setVisible(false);
                playerSpeed = 3;
                jumpDownSpeed = 5;
                parallelTransition.play();
                enemyTransition.play();

            }

            if(player.getBoundsInParent().intersects(enemy.getBoundsInParent())){
                labelLose.setVisible(true);
                playerSpeed = 0;
                jumpDownSpeed = 0;
                parallelTransition.pause();
                enemyTransition.pause();

            }

        }
    };

    @FXML
    void initialize() {
        TranslateTransition bgOneTransition = new TranslateTransition(Duration.millis(5000),bg1); //анимация background
        bgOneTransition.setFromX(0);
        bgOneTransition.setToX(BG_WIDTH * -1);
        bgOneTransition.setInterpolator(Interpolator.LINEAR); //формат анимации(линейная)

        TranslateTransition bgTwoTransition = new TranslateTransition(Duration.millis(5000),bg2); //анимация background
        bgTwoTransition.setFromX(0);
        bgTwoTransition.setToX(BG_WIDTH * -1);
        bgTwoTransition.setInterpolator(Interpolator.LINEAR); //формат анимации(линейная)

        enemyTransition = new TranslateTransition(Duration.millis(3500),enemy); //анимация background
        enemyTransition.setFromX(0);
        enemyTransition.setToX(BG_WIDTH * -1 - 100);
        enemyTransition.setInterpolator(Interpolator.LINEAR); //формат анимации(линейная)
        enemyTransition.setCycleCount(Animation.INDEFINITE);
        enemyTransition.play();


        parallelTransition = new ParallelTransition(bgOneTransition, bgTwoTransition);
        parallelTransition.setCycleCount(Animation.INDEFINITE); //бесконечный повтор картинки
        parallelTransition.play();

        timer.start();//запускаем таймер
    }
}



