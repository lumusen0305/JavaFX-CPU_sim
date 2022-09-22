# JavaFX-CPU_sim
## 實驗目的
幫助了解在不同的存儲管理方式下，應怎樣實現主存空間的分配和回收。
## 實驗內容
主存儲器空間的分配和回收
在可變分區管理方式下，採用最先適應算法實現主存空間的分配和回收。
## 實驗方法
用javafx進行編成，並且在實驗一的基礎上擴展高調功能以及分配回收機制
## 實驗步驟
+ 修改樣式(之前評分學長說我的樣式不太好看)
+ 新增Widgh 用來模擬內存
+ 設定虛擬內存，並將高調的中繼歸於最先適應算法
+ 處理需擬內存分配、合併、回收邏輯
## 實驗步驟
### 樣式
    #BorderPane1{
        -fx-background-color: linear-gradient(#00f7ff,#ffffff);
    }
    .Btn {
        -fx-background-color: #537ae6;

    }
    .Btn:hover{
        -fx-background-color:#4275ff;
    }
### 新增Widgh 用來模擬內存
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
### 處理需擬內存分配、合併、回收邏輯
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