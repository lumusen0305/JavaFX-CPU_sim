package controller;

import com.jfoenix.controls.JFXListView;
import enity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class mainController   implements Initializable {
    int figure;
    Timer timer = new Timer();//实例化Timer类
    boolean flag = true;
    int[] list;
    boolean judgefull = false;
    @FXML
    private Stage space;

    @FXML
    private ChoiceBox<String> choiceBox1;
    @FXML
    private ChoiceBox<String> choiceBox2;
    @FXML
    private ChoiceBox<String> choiceBox3;
    @FXML
    private ChoiceBox<String> choiceBox4;
    @FXML
    private ChoiceBox<String> figureOfWay;

    @FXML
    private TextField AName;
    @FXML
    private TextField BName;
    @FXML
    private TextField CName;
    @FXML
    private TextField DName;

    @FXML
    private TextField ATime;
    @FXML
    private TextField BTime;
    @FXML
    private TextField CTime;
    @FXML
    private TextField DTime;

    @FXML
    private TextField AKB;
    @FXML
    private TextField BKB;
    @FXML
    private TextField CKB;
    @FXML
    private TextField DKB;

    @FXML
    private JFXListView<String> WaitProcess = new JFXListView<>();
    @FXML
    private JFXListView<String> WaitTime = new JFXListView<>();
    @FXML
    private JFXListView<String> WaitPriority = new JFXListView<>();
    @FXML
    private JFXListView<String> WaitKB = new JFXListView<>();

    @FXML
    private JFXListView<String> ReadyProcess = new JFXListView<>();
    @FXML
    private JFXListView<String> ReadyTime = new JFXListView<>();
    @FXML
    private JFXListView<String> ReadyPriority = new JFXListView<>();
    @FXML
    private JFXListView<String> ReadyPCB = new JFXListView<>();

    @FXML
    private JFXListView<String> HoldProcess = new JFXListView<>();
    @FXML
    private JFXListView<String> HoldTime = new JFXListView<>();
    @FXML
    private JFXListView<String> HoldPriority = new JFXListView<>();

    @FXML
    private JFXListView<String> FinalProcess = new JFXListView<>();
    @FXML
    private TextField CPUrocess;
    @FXML
    private TextField CPUTime;
    @FXML
    private TextField CPUriority;

    private Text text11 = new Text(" ");
    private Text text12 = new Text(" ");
    private Text text13 = new Text(" ");
    private Text text14 = new Text(" ");

    private Text text21 = new Text(" ");
    private Text text22 = new Text(" ");
    private Text text23 = new Text(" ");
    private Text text24 = new Text(" ");

    private Text text31 = new Text(" ");
    private Text text32 = new Text(" ");
    private Text text33 = new Text(" ");
    private Text text34 = new Text(" ");

    private Text text41 = new Text(" ");
    private Text text42 = new Text(" ");
    private Text text43 = new Text(" ");
    private Text text44 = new Text(" ");
    private Text Space = new Text("512");
    private Text text51 = new Text(" ");
    private Text text52 = new Text(" ");
    private Text text53 = new Text(" ");
    private Text text54 = new Text(" ");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox1.getItems().add("NO");
        choiceBox1.getItems().add("1");
        choiceBox1.getItems().add("2");
        choiceBox1.getItems().add("3");
        choiceBox1.getItems().add("4");
        choiceBox1.getItems().add("5");

        choiceBox2.getItems().add("NO");
        choiceBox2.getItems().add("1");
        choiceBox2.getItems().add("2");
        choiceBox2.getItems().add("3");
        choiceBox2.getItems().add("4");
        choiceBox2.getItems().add("5");

        choiceBox3.getItems().add("NO");
        choiceBox3.getItems().add("1");
        choiceBox3.getItems().add("2");
        choiceBox3.getItems().add("3");
        choiceBox3.getItems().add("4");
        choiceBox3.getItems().add("5");

        choiceBox4.getItems().add("NO");
        choiceBox4.getItems().add("1");
        choiceBox4.getItems().add("2");
        choiceBox4.getItems().add("3");
        choiceBox4.getItems().add("4");
        choiceBox4.getItems().add("5");

        figureOfWay.getItems().add("1");
        figureOfWay.getItems().add("2");
        figureOfWay.getItems().add("3");
        figureOfWay.getItems().add("4");
        figureOfWay.getItems().add("5");
        WaitProcess.getItems().add("進程名");
        WaitTime.getItems().add("時間");
        WaitKB.getItems().add("KB");
        WaitPriority.getItems().add("優先級");
        ReadyProcess.getItems().add("進程名");
        ReadyTime.getItems().add("時間");
        ReadyPriority.getItems().add("優先級");
        ReadyPCB.getItems().add("PCB指針優先級");
        HoldProcess.getItems().add("進程名");
        HoldTime.getItems().add("時間");
        HoldPriority.getItems().add("優先級");
        space = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(150, 200);
        gridPane.setVgap(3);
        gridPane.setHgap(7);
        Scene scene = new Scene(gridPane);
        space.setScene(scene);
        Text text1 = new Text("進程名");
        Text text2 = new Text("起始地址");
        Text text3 = new Text("長度(KB)");
        Text text4 = new Text("狀態");

        Text KB = new Text("KB");
//        for (int i=0;i<5;i++){
//            for (int j=0;j<3;j++){
//                text[i][j].setText("123");
//                gridPane.add(text[i][j], j,i+1);
//            }
//        }
//        gridPane.add(text[0][0], 0, 1);

        gridPane.add(text1, 0, 0);
        gridPane.add(text2, 1, 0);
        gridPane.add(text3, 2, 0);
        gridPane.add(text4, 3, 0);

        gridPane.add(text11, 0, 1);
        gridPane.add(text12, 1, 1);
        gridPane.add(text13, 2, 1);
        gridPane.add(text14, 3, 1);

        gridPane.add(text21, 0, 2);
        gridPane.add(text22, 1, 2);
        gridPane.add(text23, 2, 2);
        gridPane.add(text24, 3, 2);

        gridPane.add(text31, 0, 3);
        gridPane.add(text32, 1, 3);
        gridPane.add(text33, 2, 3);
        gridPane.add(text34, 3, 3);

        gridPane.add(text41, 0, 4);
        gridPane.add(text42, 1, 4);
        gridPane.add(text43, 2, 4);
        gridPane.add(text44, 3, 4);

        gridPane.add(text51, 0, 5);
        gridPane.add(text52, 1, 5);
        gridPane.add(text53, 2, 5);
        gridPane.add(text54, 3, 5);

        gridPane.add(Space, 2, 17);
        gridPane.add(KB, 3, 17);
        space.show();

    }

    //添加到後背
    public void AddToWait(ActionEvent actionEvent) {

        Item A = new Item();
        A.setName(AName.getText());
        A.setTime(ATime.getText());
        A.setKB(AKB.getText());
        A.setPriority(choiceBox1.getValue());

        Item B = new Item();
        B.setName(BName.getText());
        B.setTime(BTime.getText());
        B.setKB(BKB.getText());
        B.setPriority(choiceBox2.getValue());
        Item C = new Item();
        C.setName(CName.getText());
        C.setTime(CTime.getText());
        C.setKB(CKB.getText());
        C.setPriority(choiceBox3.getValue());

        Item D = new Item();
        D.setName(DName.getText());
        D.setTime(DTime.getText());
        D.setKB(DKB.getText());
        D.setPriority(choiceBox4.getValue());
        if (A.getPriority() != "NO" && A.getPriority() != null) {
            WaitProcess.getItems().add(A.getName());
            WaitTime.getItems().add(A.getTime());
            WaitKB.getItems().add(A.getKB());
            WaitPriority.getItems().add(A.getPriority());
        }
        if (B.getPriority() != "NO" && B.getPriority() != null) {
            WaitProcess.getItems().add(B.getName());
            WaitTime.getItems().add(B.getTime());
            WaitKB.getItems().add(B.getKB());
            WaitPriority.getItems().add(B.getPriority());
        }
        if (C.getPriority() != "NO" && C.getPriority() != null) {
            WaitProcess.getItems().add(C.getName());
            WaitTime.getItems().add(C.getTime());
            WaitKB.getItems().add(C.getKB());
            WaitPriority.getItems().add(C.getPriority());
        }
        if (D.getPriority() != "NO" && D.getPriority() != null) {
            WaitProcess.getItems().add(D.getName());
            WaitTime.getItems().add(D.getTime());
            WaitKB.getItems().add(D.getKB());
            WaitPriority.getItems().add(D.getPriority());
        }
        choiceBox1.getSelectionModel().selectFirst();
        choiceBox2.getSelectionModel().selectFirst();
        choiceBox3.getSelectionModel().selectFirst();
        choiceBox4.getSelectionModel().selectFirst();
        AName.setText("");
        BName.setText("");
        CName.setText("");
        DName.setText("");
        ATime.setText("");
        BTime.setText("");
        CTime.setText("");
        DTime.setText("");
        AKB.setText("");
        BKB.setText("");
        CKB.setText("");
        DKB.setText("");
        figure = Integer.parseInt(figureOfWay.getValue());

    }

    //清掉ADD
    public void Clear(ActionEvent actionEvent) {
        choiceBox1.getSelectionModel().selectFirst();
        choiceBox2.getSelectionModel().selectFirst();
        choiceBox3.getSelectionModel().selectFirst();
        choiceBox4.getSelectionModel().selectFirst();
        AName.setText("");
        BName.setText("");
        CName.setText("");
        DName.setText("");
        ATime.setText("");
        BTime.setText("");
        CTime.setText("");
        DTime.setText("");
    }


    public void run(ActionEvent actionEvent) {
        Text[][] text = new Text[5][4];
        text[0][0] = text11;
        text[0][1] = text12;
        text[0][2] = text13;
        text[0][3] = text14;

        text[1][0] = text21;
        text[1][1] = text22;
        text[1][2] = text23;
        text[1][3] = text24;

        text[2][0] = text31;
        text[2][1] = text32;
        text[2][2] = text33;
        text[2][3] = text34;

        text[3][0] = text41;
        text[3][1] = text42;
        text[3][2] = text43;
        text[3][3] = text44;

        text[4][0] = text51;
        text[4][1] = text52;
        text[4][2] = text53;
        text[4][3] = text54;
        int count = 0;

//============================Waiting->Ready===============================
        if (ReadyProcess.getItems().toArray().length - 1 < Integer.parseInt(figureOfWay.getValue())) {
            if (WaitPriority.getItems().toArray().length - 1 > 0) {
                for (int i = 0; i <= WaitPriority.getItems().toArray().length; i++) {
                    if (Integer.parseInt(WaitKB.getItems().get(1)) > Integer.parseInt(Space.getText())) {
                        WaitProcess.getItems().add(WaitProcess.getItems().get(1));
                        WaitTime.getItems().add(WaitTime.getItems().get(1));
                        WaitKB.getItems().add(WaitKB.getItems().get(1));
                        WaitPriority.getItems().add(WaitPriority.getItems().get(1));

                        WaitProcess.getItems().remove(1);
                        WaitTime.getItems().remove(1);
                        WaitKB.getItems().remove(1);
                        WaitPriority.getItems().remove(1);
                    } else {
                        if (ReadyPriority.getItems().toArray().length - 1 < Integer.parseInt(figureOfWay.getValue())) {
                            ReadyProcess.getItems().add(String.valueOf(WaitProcess.getItems().toArray()[1]));
                            ReadyTime.getItems().add(String.valueOf(WaitTime.getItems().toArray()[1]));
                            ReadyPriority.getItems().add(String.valueOf(WaitPriority.getItems().toArray()[1]));
                            ReadyPCB.getItems().add("");
                            Space.setText(Integer.toString(Integer.parseInt(Space.getText()) - Integer.parseInt(String.valueOf(WaitKB.getItems().toArray()[1]))));
                            text[count][0].setText(String.valueOf(WaitProcess.getItems().toArray()[1]));
                            if (count > 0)
                                text[count][1].setText(String.valueOf(Integer.parseInt(text[count - 1][1].getText()) + Integer.parseInt(text[count - 1][2].getText())));
                            else
                                text[count][1].setText("0");
                            text[count][2].setText(String.valueOf(WaitKB.getItems().toArray()[1]));
                            text[count][3].setText("占用");
                            count++;

                            WaitProcess.getItems().remove(1);
                            WaitTime.getItems().remove(1);
                            WaitKB.getItems().remove(1);
                            WaitPriority.getItems().remove(1);
                        }

                    }
                }

            }
        }

//=========================================================================


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//============================判斷ｒｅａｄｙ是否可以再裝===============================
                if (ReadyProcess.getItems().toArray().length - 1 + HoldProcess.getItems().toArray().length - 1 < Integer.parseInt(figureOfWay.getValue())) {
                    if (WaitPriority.getItems().toArray().length > 1) {
                        if (false) {
                            WaitProcess.getItems().add(WaitProcess.getItems().get(1));
                            WaitTime.getItems().add(WaitTime.getItems().get(1));
                            WaitKB.getItems().add(WaitKB.getItems().get(1));
                            WaitPriority.getItems().add(WaitPriority.getItems().get(1));

                            WaitProcess.getItems().remove(1);
                            WaitTime.getItems().remove(1);
                            WaitKB.getItems().remove(1);
                            WaitPriority.getItems().remove(1);
                        }
                        else {
                            int index=-1;
                            boolean flag2=true;
                            int count1=0;
                            while (flag2){
                                if (Integer.parseInt(WaitKB.getItems().get(1))-Integer.parseInt(text[count1][2].getText())>=0){
                                    index=count1;
                                    break;
                                }
                                if (count1>5){
                                    break;
                                }
                                count1++;
                            }
                            System.out.print("sss"+index);
                            if (index!=-1){
                                text[index][0].setText(WaitProcess.getItems().get(1));
                                text[index][3].setText("占用");
                            }
                            else {
                                Space.setText(Integer.toString(Integer.parseInt(Space.getText()) - Integer.parseInt(String.valueOf(WaitKB.getItems().toArray()[1]))));
                                boolean flag1=true;
                                for (int i=0;i<5;i++){
                                    if (flag1&&text[i][3].equals(" ")){
                                        if (i > 0)
                                            text[i][1].setText(String.valueOf(Integer.parseInt(text[i - 1][1].getText()) + Integer.parseInt(text[i - 1][2].getText())));
                                        else
                                            text[i][1].setText("0");
                                        text[i][1].setText("0");
                                        text[i][2].setText(String.valueOf(WaitKB.getItems().toArray()[1]));
                                        text[i][3].setText("占用");
                                        flag1=false;
                                    }
                                }
                            }
                            ReadyProcess.getItems().add(String.valueOf(WaitProcess.getItems().toArray()[1]));
                            ReadyTime.getItems().add(String.valueOf(WaitTime.getItems().toArray()[1]));
                            ReadyPriority.getItems().add(String.valueOf(WaitPriority.getItems().toArray()[1]));
                            ReadyPCB.getItems().add("");


                            WaitProcess.getItems().remove(1);
                            WaitTime.getItems().remove(1);
                            WaitKB.getItems().remove(1);
                            WaitPriority.getItems().remove(1);
                        }
                    }
                }


//=================================調用=============================================
                if (flag) {
                    int i = findMaxIndex(stringToInt(ReadyPriority.getItems().toArray()));
                    CPUrocess.setText(ReadyProcess.getItems().get(i + 1));
                    CPUriority.setText(ReadyPriority.getItems().get(i + 1));
                    CPUTime.setText(ReadyTime.getItems().get(i + 1));
                    ReadyProcess.getItems().set(i + 1, "調用中．．．");
                    ReadyPCB.getItems().set(i + 1, "調用中．．．");
                    ReadyPriority.getItems().set(i + 1, "調用中．．．");
//                    ReadyTime.getItems().set(i, Integer.toString(Integer.parseInt(CPUTime.getText()) - 1));
                    flag = false;
                } else {
                    int i = ReadyPriority.getItems().indexOf("調用中．．．");
                    ReadyProcess.getItems().set(i, CPUrocess.getText());
                    ReadyPCB.getItems().set(i, " ");
                    ReadyPriority.getItems().set(i, CPUriority.getText());
                    ReadyTime.getItems().set(i, Integer.toString(Integer.parseInt(CPUTime.getText()) - 1));
                    flag = true;
                }
                for (int i = 0; i < stringToInt(ReadyTime.getItems().toArray()).length; i++) {
                    if (stringToInt(ReadyTime.getItems().toArray())[i] <= 0) {

                        FinalProcess.getItems().add(ReadyProcess.getItems().get(i + 1));
//                        FinalTime.getItems().add(ReadyTime.getItems().get(i + 1));

                        for (int k=0;k<5;k++) {
                            if (text[k][0].getText().equals(ReadyProcess.getItems().get(i + 1))) {
                                text[k][3].setText("Free");
                                text[k][0].setText(" ");
                            }
                            if (k < 4) {
                                if (text[k][3].getText().equals(text[k + 1][3].getText())) {
                                if (text[k][3].getText().equals("Free")) {
                                    text[k][2].setText(Integer.toString(Integer.parseInt(text[k][2].getText()) + (Integer.parseInt(text[k + 1][2].getText()))));
                                    text[k + 1][3].setText("以合併");
                                    for (int y = k+1; y < 4; y++) {
                                        for (int p = 0; p < 4; p++) {
                                            System.out.print("5555555555");
                                            text[y][p].setText(text[y + 1][p].getText());
                                        }
                                    }
                                }
                                }
                            }

                        }
                        ReadyProcess.getItems().remove(i + 1);
                        ReadyTime.getItems().remove(i + 1);
                        ReadyPCB.getItems().remove(i + 1);
                        ReadyPriority.getItems().remove(i + 1);


                    }
                }

//============================排最大優先級等級==============================
//                    if (judgePCB()) {
//                        decidePCB();
//                    }

            }
        }, 1000, 1000);
        decidePCB();

    }

    public int[] stringToInt(Object[] arr) {
        int[] array = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            array[i - 1] = Integer.parseInt(String.valueOf(arr[i]));
        }
        return array;
    }

    public int findMaxIndex(int[] arr) {
        int maxFigure = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[maxFigure] < arr[i]) {
                maxFigure = i;
            }
        }
        return maxFigure;
    }

    public void holdProcess(ActionEvent actionEvent) {
//text1.setText("123");
    }

    public int[] sortMaxIndexLisr(int[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int Max = findMaxIndex(arr);
            arr[Max] = 0;
            array[i] = Max;
        }
        return array;
    }

    public boolean judgePCB() {
        boolean flag = false;
        for (int i = 1; i < ReadyPCB.getItems().toArray().length; i++) {
            if (ReadyPCB.getItems().toArray()[i] == "null") {
                flag = true;
            }
        }
        return flag;
    }

    //===============================掛起================================
    public void holdReadrList(MouseEvent mouseEvent) {
//        System.out.println(ReadyProcess.getItems().toArray()[mouseEvent.getClickCount()]);
        if (ReadyProcess.getSelectionModel().getSelectedIndex() != 0) {
            System.out.println(ReadyProcess.getSelectionModel().getSelectedIndex());
            HoldPriority.getItems().add(String.valueOf(ReadyPriority.getItems().toArray()[ReadyProcess.getSelectionModel().getSelectedIndex()]));
            HoldProcess.getItems().add(String.valueOf(ReadyProcess.getItems().toArray()[ReadyProcess.getSelectionModel().getSelectedIndex()]));
            HoldTime.getItems().add(String.valueOf(ReadyTime.getItems().toArray()[ReadyProcess.getSelectionModel().getSelectedIndex()]));
            ReadyProcess.getItems().remove(ReadyProcess.getSelectionModel().getSelectedIndex());
            ReadyPCB.getItems().remove(ReadyProcess.getSelectionModel().getSelectedIndex() + 1);
            ReadyPriority.getItems().remove(ReadyProcess.getSelectionModel().getSelectedIndex() + 1);
            ReadyTime.getItems().remove(ReadyProcess.getSelectionModel().getSelectedIndex() + 1);
        }
    }

    //==========================================================
    public void doProcess(ActionEvent actionEvent) {
        Space.setText("123");

    }

    public void decidePCB() {
        int[] list;
        list = sortMaxIndexLisr(stringToInt(ReadyPriority.getItems().toArray()));
        for (int i = 0; i < list.length - 1; i++) {
            ReadyPCB.getItems().set(list[i] + 1, ReadyProcess.getItems().get(list[i + 1] + 1));
        }
    }

    public void CancelholdReadrList(MouseEvent mouseEvent) {
        if (HoldProcess.getSelectionModel().getSelectedIndex() != 0) {
            ReadyTime.getItems().add(String.valueOf(HoldTime.getItems().toArray()[HoldProcess.getSelectionModel().getSelectedIndex()]));
            ReadyProcess.getItems().add(String.valueOf(HoldProcess.getItems().toArray()[HoldProcess.getSelectionModel().getSelectedIndex()]));
            ReadyPriority.getItems().add(String.valueOf(HoldPriority.getItems().toArray()[HoldProcess.getSelectionModel().getSelectedIndex()]));
            ReadyPCB.getItems().add(" ");
            HoldProcess.getItems().remove(HoldProcess.getSelectionModel().getSelectedIndex());
            HoldTime.getItems().remove(HoldProcess.getSelectionModel().getSelectedIndex() + 1);
            HoldPriority.getItems().remove(HoldProcess.getSelectionModel().getSelectedIndex() + 1);
        }
    }

    public void test(ActionEvent actionEvent) {
        System.out.println("123");
    }

    public int choseSpaceIndex(int mySpace) {

        Text[][] text = new Text[5][4];
        text[0][0] = text11;
        text[0][1] = text12;
        text[0][2] = text13;
        text[0][3] = text14;

        text[1][0] = text21;
        text[1][1] = text22;
        text[1][2] = text23;
        text[1][3] = text24;

        text[2][0] = text31;
        text[2][1] = text32;
        text[2][2] = text33;
        text[2][3] = text34;

        text[3][0] = text41;
        text[3][1] = text42;
        text[3][2] = text43;
        text[3][3] = text44;

        text[4][0] = text51;
        text[4][1] = text52;
        text[4][2] = text53;
        text[4][3] = text54;
        int flag=0;
        int index=-1;
        int count =0;
        while (flag==0) {
            if (mySpace - Integer.parseInt(Space.getText()) >= 0 && text[count][3].getText().equals("Free")) {
                flag++;
                count++;
                index=count;
            }
        }
        return index;
    }
}