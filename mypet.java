import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DesktopPet extends Application {

    private static final int WINDOW_WIDTH = 200;   // 窗口宽度
    private static final int WINDOW_HEIGHT = 200;  // 窗口高度
    private static final int IMAGE_SIZE = 100;     // 图片大小

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 创建一个堆叠面板作为根容器
        StackPane root = new StackPane();

        // 创建一个 ImageView 来显示桌宠的图片
        Image image = new Image("pet.png");  // 替换为你的桌宠图片路径
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(IMAGE_SIZE);
        imageView.setFitHeight(IMAGE_SIZE);

        // 将 ImageView 添加到根容器
        root.getChildren().add(imageView);

        // 设置根容器居中
        root.setAlignment(Pos.CENTER);

        // 创建一个 Timeline，每隔一段时间改变桌宠的位置
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), event -> {
                    double newX = Math.random() * (WINDOW_WIDTH - IMAGE_SIZE);
                    double newY = Math.random() * (WINDOW_HEIGHT - IMAGE_SIZE);
                    imageView.setTranslateX(newX);
                    imageView.setTranslateY(newY);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // 创建一个场景并将根容器放入场景
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        // 设置窗口标题和场景，并显示窗口
        primaryStage.setTitle("Desktop Pet");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
