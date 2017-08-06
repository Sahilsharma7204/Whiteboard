
import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Client extends javax.swing.JFrame
{
    
   
    changepassword cpp;
    forgetpass fpp;
    int lol = 0, ncon = 0;
    DataOutputStream dos;
    DataInputStream dis;
    StudentSignup signup;
    SLogin sslogin;
    StudentDiscussion discussion;
     String text="";   
       ArrayList<Drawing> alDrawing = new ArrayList<>();
    WhiteBoard whiteBoard;

    public Client()
    {
        initComponents();
        setResizable(false);
        setSize(350, 400);
        setTitle("STUDENT");
        btnSignup.setEnabled(false);
        btlogin.setEnabled(false);
        btforgetpass.setEnabled(false);
        btnchangep.setEnabled(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void openmain()
    {this.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfip = new javax.swing.JTextField();
        btcon = new javax.swing.JButton();
        btnSignup = new javax.swing.JButton();
        btlogin = new javax.swing.JButton();
        labipaddress = new javax.swing.JLabel();
        btexit = new javax.swing.JButton();
        btnchangep = new javax.swing.JButton();
        btforgetpass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(tfip);
        tfip.setBounds(10, 30, 130, 30);

        btcon.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btcon.setText("Connect to Server");
        btcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconActionPerformed(evt);
            }
        });
        getContentPane().add(btcon);
        btcon.setBounds(150, 30, 160, 30);

        btnSignup.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSignup.setText("STUDENT SIGNUP");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignup);
        btnSignup.setBounds(10, 100, 140, 30);

        btlogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btlogin.setText("STUDENT LOGIN");
        btlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloginActionPerformed(evt);
            }
        });
        getContentPane().add(btlogin);
        btlogin.setBounds(170, 100, 140, 30);

        labipaddress.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        labipaddress.setText("IP Address");
        getContentPane().add(labipaddress);
        labipaddress.setBounds(50, 10, 70, 20);

        btexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btexit.setText("EXIT");
        btexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexitActionPerformed(evt);
            }
        });
        getContentPane().add(btexit);
        btexit.setBounds(110, 220, 100, 30);

        btnchangep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnchangep.setText("CHANGE PASS.");
        btnchangep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangepActionPerformed(evt);
            }
        });
        getContentPane().add(btnchangep);
        btnchangep.setBounds(10, 150, 140, 30);

        btforgetpass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btforgetpass.setText("FORGET PASS.");
        btforgetpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btforgetpassActionPerformed(evt);
            }
        });
        getContentPane().add(btforgetpass);
        btforgetpass.setBounds(170, 150, 140, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconActionPerformed
        if (lol == 0)
        {
            ncon = 0;
            Inner obj = new Inner();
            Thread t1 = new Thread(obj);
            t1.start();
            
        } else
        {
            JOptionPane.showMessageDialog(this, "ALREADY CONNECTED ");
        }
    }//GEN-LAST:event_btconActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSignupActionPerformed
    {//GEN-HEADEREND:event_btnSignupActionPerformed
        signup = new StudentSignup();
        
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloginActionPerformed
        sslogin = new SLogin();
    }//GEN-LAST:event_btloginActionPerformed

    private void btexitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btexitActionPerformed
    {//GEN-HEADEREND:event_btexitActionPerformed
int exi=JOptionPane.showConfirmDialog(this, "Are you sure to EXIT", "EXIT", JOptionPane.YES_NO_OPTION);
if(exi==0)
{System.exit(0);}
    }//GEN-LAST:event_btexitActionPerformed

    private void btnchangepActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnchangepActionPerformed
    {//GEN-HEADEREND:event_btnchangepActionPerformed
        // TODO add your handling code here:
        cpp=new changepassword();
    }//GEN-LAST:event_btnchangepActionPerformed

    private void btforgetpassActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btforgetpassActionPerformed
    {//GEN-HEADEREND:event_btforgetpassActionPerformed
        // TODO add your handling code here:
        fpp=new forgetpass();
    }//GEN-LAST:event_btforgetpassActionPerformed

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcon;
    private javax.swing.JButton btexit;
    javax.swing.JButton btforgetpass;
    javax.swing.JButton btlogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JButton btnchangep;
    private javax.swing.JLabel labipaddress;
    private javax.swing.JTextField tfip;
    // End of variables declaration//GEN-END:variables

    class Inner implements Runnable
    {

        String response;

        public Inner()
        {
            try
            {String ipaddress=tfip.getText();
                Socket sock = new Socket(ipaddress, 9000);
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
                btcon.setText("CONNECTED");
                btcon.setBackground(Color.red);
                tfip.setFocusable(false);
                btnSignup.setEnabled(true);
                btlogin.setEnabled(true);
                btforgetpass.setEnabled(true);
                btnchangep.setEnabled(true);
                FileReceiverServer server = new FileReceiverServer();
                Thread thread = new Thread(server);
                thread.start();
                lol++;
            } catch (Exception ex)
            {
                tfip.setText("INVALID IP");
                ncon = 5;
            }
        }

        public void run()
        {
            try
            {
                if (ncon == 0)
                {
                    while (true)
                    {
                        response = dis.readLine();
                        if (response.equals("signup_true"))
                        {
                            JOptionPane.showMessageDialog(signup, "Signup Successful");
                            signup.setVisible(false);
                            openmain();
                        } else if (response.equals("signup_false"))
                        {
                            JOptionPane.showMessageDialog(signup, "Signup Failed");
                        } else if (response.equals("login_false"))
                        {
                            JOptionPane.showMessageDialog(sslogin, "Login Failed");
                        }  else if (response.equals("changetrue"))
                        {
                            JOptionPane.showMessageDialog(cpp, "Password changed");
                        } else if (response.equals("changefalse"))
                        {
                            JOptionPane.showMessageDialog(cpp, "Invalid User");
                        }  else if (response.equals("forgettrue"))
                        {
                            JOptionPane.showMessageDialog(fpp, "Password changed");
                        } else if (response.equals("forgetfalse"))
                        {
                            JOptionPane.showMessageDialog(fpp, "Invalid User");
                        } 
                         else if (response.equals("forgetques"))
                        {
                     String nam=dis.readLine();
                       fpp.jLabel5fp.setVisible(true);
        fpp.jLabel4fp.setVisible(true);
        fpp.jLabel3fp.setVisible(true);
        fpp.jLabel3cpf.setVisible(true);
        fpp.tfcpansff.setVisible(true);
        fpp.tfcpnewpassff.setVisible(true);
        fpp.tfcpconfffff.setVisible(true);
        fpp.btchangepassforg.setVisible(true);
        fpp.lbquestion.setText(nam+"  ?");
        
                        } 
                          else if (response.equals("forgetnodata"))
                        {
                            JOptionPane.showMessageDialog(fpp, "Invalid User");
                        } 
                        
                        
                        
                        
                        else if (response.equals("login_true"))
                        {
                            JOptionPane.showMessageDialog(sslogin, "Login Success FULL");
                            sslogin.btSlogin.setEnabled(false);
                btlogin.setEnabled(false);
                sslogin.setVisible(false);
                        } else if (response.equals("message"))
                        {
                            String teacherName = dis.readLine();
                            String message = dis.readLine();
                            if (discussion == null)
                            {
                                discussion = new StudentDiscussion();
                            }discussion.setVisible(true);
                            discussion.ta_message_history.append(teacherName + "  Sir : " + message + "\n");
                        }else if (response.equals("drawing"))
                    {
                       if(whiteBoard == null)
                        {
                           whiteBoard = new WhiteBoard();
                        }
                       whiteBoard.setVisible(true);
                        alDrawing.clear();
                        int size = dis.readInt();
                        for (int i = 0; i < size; i++)
                        {
                            String shapeType = dis.readLine();
                            int startingX = dis.readInt();
                            int startingY = dis.readInt();
                            int endingX = dis.readInt();
                            int endingY = dis.readInt();
                            int red = dis.readInt();
                            int green = dis.readInt();
                            int blue = dis.readInt();
                            int stroke = dis.readInt();
                            boolean isSolid = dis.readBoolean();
                         text = dis.readLine();
                            alDrawing.add(new Drawing(shapeType, startingX, startingY, endingX, endingY, new Color(red, green, blue), stroke, isSolid, text));
                        whiteBoard.repaint();
                        }
                    }

                    }
                }
            } catch (Exception e)
            {
             JOptionPane.showMessageDialog(Client.this,"  Teacher Exited ");
            }
        }
    }

    public class StudentSignup extends javax.swing.JFrame
    {

        public StudentSignup()
        {setLocationRelativeTo(Client.this);
            setTitle("STUDENT SIGN-UP");
            initComponents();
            setResizable(false);
            setVisible(true);
            setSize(450, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            signup = new javax.swing.JButton();
            mblb = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            namelb = new javax.swing.JLabel();
            tfname = new javax.swing.JTextField();
            tfmob = new javax.swing.JTextField();
            tfemail = new javax.swing.JTextField();
            tfseq_ques = new javax.swing.JTextField();
            tfseq_ans = new javax.swing.JTextField();
            tfpassword = new javax.swing.JPasswordField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);

            signup.setText("SIGN UP");
            signup.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    signupActionPerformed(evt);
                }
            });
            getContentPane().add(signup);
            signup.setBounds(170, 420, 100, 30);

            mblb.setText("MOBILE NO.");
            getContentPane().add(mblb);
            mblb.setBounds(15, 90, 100, 20);

            jLabel2.setText("EMAIL");
            getContentPane().add(jLabel2);
            jLabel2.setBounds(15, 150, 40, 20);

            jLabel3.setText("PASSWORD");
            getContentPane().add(jLabel3);
            jLabel3.setBounds(15, 210, 100, 14);

            jLabel4.setText("SECURITY QUST.");
            getContentPane().add(jLabel4);
            jLabel4.setBounds(15, 275, 100, 14);

            jLabel5.setText("SECURITY ANS.");
            getContentPane().add(jLabel5);
            jLabel5.setBounds(15, 340, 100, 20);

            namelb.setText("NAME");
            getContentPane().add(namelb);
            namelb.setBounds(15, 40, 40, 14);
            getContentPane().add(tfname);
            tfname.setBounds(130, 40, 240, 30);
            getContentPane().add(tfmob);
            tfmob.setBounds(130, 90, 240, 30);
            getContentPane().add(tfemail);
            tfemail.setBounds(130, 150, 240, 30);
            getContentPane().add(tfseq_ques);
            tfseq_ques.setBounds(130, 270, 240, 30);
            getContentPane().add(tfseq_ans);
            tfseq_ans.setBounds(130, 340, 240, 30);
            getContentPane().add(tfpassword);
            tfpassword.setBounds(130, 210, 240, 30);

            pack();
        }// </editor-fold>                        

        private void signupActionPerformed(java.awt.event.ActionEvent evt)
        {
            String name = tfname.getText();
            String email = tfemail.getText();
            String mob = tfmob.getText();
            String secQues = tfseq_ques.getText();
            String secAns = tfseq_ans.getText();
            String password = tfpassword.getText();
            if (name.equals("") || mob.equals("") || email.equals("") || secQues.equals("") || secAns.equals("") || (password.equals("")))
            {
                JOptionPane.showMessageDialog(this, "All Fields are compulsary");
            } else if (mob.length() != 10)
            {
                JOptionPane.showMessageDialog(this, "Mobile no should be 10 digits");
            } else
            {
                try
                {
                    dos.writeBytes("student_signup\r\n"); //requset
                    dos.writeBytes(name + "\r\n");
                    dos.writeBytes(email + "\r\n");
                    dos.writeBytes(mob + "\r\n");
                    dos.writeBytes(secQues + "\r\n");
                    dos.writeBytes(secAns + "\r\n");
                    dos.writeBytes(password + "\r\n");
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }

        }

        // Variables declaration - do not modify                     
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel mblb;
        private javax.swing.JLabel namelb;
        private javax.swing.JButton signup;
        private javax.swing.JTextField tfemail;
        private javax.swing.JTextField tfmob;
        private javax.swing.JTextField tfname;
        private javax.swing.JPasswordField tfpassword;
        private javax.swing.JTextField tfseq_ans;
        private javax.swing.JTextField tfseq_ques;
        // End of variables declaration                   
    }

    public class SLogin extends javax.swing.JFrame
    {

        public SLogin()
        {setLocationRelativeTo(Client.this);
            initComponents();
            setResizable(false);
            setVisible(true);
            setSize(400, 400);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            tfpassword_login = new javax.swing.JPasswordField();
            tfmob_login = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            btSlogin = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            jLabel1.setText("MOBILE NO.");
            getContentPane().add(jLabel1);
            jLabel1.setBounds(40, 76, 74, 14);

            jLabel2.setText("PASSWORD");
            getContentPane().add(jLabel2);
            jLabel2.setBounds(40, 127, 62, 14);
            getContentPane().add(tfpassword_login);
            tfpassword_login.setBounds(152, 124, 160, 30);
            getContentPane().add(tfmob_login);
            tfmob_login.setBounds(152, 73, 160, 30);

            jLabel3.setForeground(new java.awt.Color(250, 0, 0));
             jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
            jLabel3.setText("STUDENT LOGIN ");
            getContentPane().add(jLabel3);
            jLabel3.setBounds(115, 10, 150, 30);

            btSlogin.setText("LOGIN");
            btSlogin.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btSloginActionPerformed(evt);
                }
            });
            getContentPane().add(btSlogin);
            btSlogin.setBounds(110, 250, 140, 40);

            pack();
        }// </editor-fold>                        

        private void btSloginActionPerformed(java.awt.event.ActionEvent evt)
        {
            try
            {
                String mo = tfmob_login.getText();
                String pa = tfpassword_login.getText();
                dos.writeBytes("student_login\r\n"); //requset
                System.out.println("ho gya");
                dos.writeBytes(mo + "\r\n");
                System.out.println("ho gya one");
                dos.writeBytes(pa + "\r\n");
                System.out.println("ho gya two");
                } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        // Variables declaration - do not modify                     
       private javax.swing.JButton btSlogin;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JTextField tfmob_login;
        private javax.swing.JPasswordField tfpassword_login;
        // End of variables declaration                   
    }

    class StudentDiscussion extends javax.swing.JFrame
    {

        public StudentDiscussion()
        {setLocationRelativeTo(Client.this);
            initComponents();
            ta_message_history.setFocusable(false);
            setVisible(true);
            setSize(500, 500);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            btnsend = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            ta_message_history = new javax.swing.JTextArea();
            tf_message = new javax.swing.JTextField();
           
            getContentPane().setLayout(null);

            btnsend.setText("SEND");
            btnsend.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnsendActionPerformed(evt);
                }
            });
            getContentPane().add(btnsend);
            btnsend.setBounds(340, 300, 80, 40);

            ta_message_history.setColumns(20);
            ta_message_history.setRows(5);
            jScrollPane1.setViewportView(ta_message_history);

            getContentPane().add(jScrollPane1);
            jScrollPane1.setBounds(10, 10, 420, 280);
            getContentPane().add(tf_message);
            tf_message.setBounds(10, 300, 320, 40);

            pack();
        }// </editor-fold>                        

        private void btnsendActionPerformed(java.awt.event.ActionEvent evt)
        {
            try
            {
                String message = tf_message.getText().trim();
                ta_message_history.append("You : " + message + "\n");
                dos.writeBytes("message\r\n");
                dos.writeBytes(message + "\r\n");
                tf_message.requestFocus();
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton btnsend;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextArea ta_message_history;
        private javax.swing.JTextField tf_message;
        // End of variables declaration                   
    }

    class FileReceiverServer implements Runnable
    {

        ServerSocket serverSocket;

        public void run()
        {
            try
            {
                serverSocket = new ServerSocket(8000);
                System.out.println("File Server Running");
                while (true)
                {
                    Socket socket = serverSocket.accept();
                    FileHandler fileHandler = new FileHandler(socket);
                    Thread thread = new Thread(fileHandler);
                    thread.start();
                }
            } catch (Exception e)
            {
            }
        }
    }

    class FileHandler implements Runnable
    {

        Socket socket;
        DataInputStream disFile;
        DataOutputStream dosFile;
        String fileRequest;

        public FileHandler(Socket socket)
        {
            try
            {
                this.socket = socket;
                disFile = new DataInputStream(socket.getInputStream());
                dosFile = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        public void run()
        {
            try
            {
                    fileRequest = disFile.readLine();
                    if (fileRequest.equals("getfile"))
                    {
                        String fileName = disFile.readLine();
                        int fileSize = (int) disFile.readLong();
                      
                        File output = new File(System.getProperty("user.home") + File.separator + "White Board Downloads");
                        if (!output.exists())
                        {
                            output.mkdirs();
                        }
                        FileOutputStream fos = new FileOutputStream(output.getPath() + File.separator + fileName);
                        byte[] buffer = new byte[1024 * 1024];
                        int count = 0;
                        while (true)
                        {
                            int read = disFile.read(buffer, 0, buffer.length);
                            fos.write(buffer, 0, read);
                            if ((count += read) == fileSize)
                            {
                                break;
                            }
                        
                        }
                        
                        JOptionPane.showMessageDialog(Client.this,"\" "+fileName+"\""+ "    File Received");
                        fos.close();
                    }
                
            } catch (Exception e)
            {
            
            }
        }
    }

   
    class Drawing
    {

        String shapeType;
        int startingX;
        int startingY;
        int endingX;
        int endingY;
        Color selectedColor;
        int stroke;
        boolean isSolid;
        String text;

        public Drawing(String shapeType, int startingX, int startingY, int endingX, int endingY, Color selectedColor, int stroke, boolean isSolid, String text)
        {
            this.shapeType = shapeType;
            this.startingX = startingX;
            this.startingY = startingY;
            this.endingX = endingX;
            this.endingY = endingY;
            this.selectedColor = selectedColor;
            this.stroke = stroke;
            this.isSolid = isSolid;
            this.text = text;
        }
    }

   public class WhiteBoard extends javax.swing.JFrame
    {

        public WhiteBoard()
        {setLocationRelativeTo(Client.this);
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);
            setSize(700,500);
        }

        public void paint(Graphics g)
        {
            super.paint(g);
            for (int i = 0; i < alDrawing.size() - 1; i++)
            {
              g.setColor(alDrawing.get(i).selectedColor);
               if (alDrawing.get(i).shapeType.equals("freehand"))
                {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    int endX = alDrawing.get(i + 1).endingX;
                    int endY = alDrawing.get(i + 1).endingY;
                    if ((startX == 0 && startY == 0) || (endX == 0 && endY == 0))
                    {
                        continue;
                    }
                    for (int lino = 0; lino <alDrawing.get(i).stroke; lino++)
                    {
                            g.drawLine(startX+lino, startY+lino, endX+lino, endY+lino);
                        
                    }
                
                }
            }
              
            for (int i = 0; i < alDrawing.size(); i++)
            {
                g.setColor(alDrawing.get(i).selectedColor);
                if (alDrawing.get(i).shapeType.equals("rect"))
                {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    int width = alDrawing.get(i).endingX;
                    int height = alDrawing.get(i).endingY;
                    if (alDrawing.get(i).isSolid)
                    {
                        g.fillRect(startX, startY, width, height);
                    } else
                    { for(int lino=0;lino<alDrawing.get(i).stroke;lino++)
                    {g.drawRect(startX+lino, startY+lino, width-2*lino, height-2*lino);
                    }}
                } else if (alDrawing.get(i).shapeType.equals("circle"))
                {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    int width = alDrawing.get(i).endingX;
                    int height = width;
                    if (alDrawing.get(i).isSolid)
                    {
                        g.fillOval(startX, startY, width, height);
                    } else
                    {for(int lino=0;lino<alDrawing.get(i).stroke;lino++)
                    {
                        g.drawOval(startX+lino, startY+lino, width-2*lino, height-2*lino);
                    } }
                } else if (alDrawing.get(i).shapeType.equals("square"))
                {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    int width = alDrawing.get(i).endingX;
                    int height = width;
                    if (alDrawing.get(i).isSolid)
                    {
                        g.fillRect(startX, startY, width, height);
                    } else
                    { for(int lino=0;lino<alDrawing.get(i).stroke;lino++)
                    {
                        g.drawRect(startX+lino, startY+lino, width-2*lino, height-2*lino);
                    }}
                } else if (alDrawing.get(i).shapeType.equals("text"))
                {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    g.drawString(alDrawing.get(i).text, startX, startY);
                }
            }
            
        }
        
        
   }   
        
        
 public class changepassword extends javax.swing.JFrame
{
  public changepassword()
    {setLocationRelativeTo(Client.this);
        initComponents();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 350);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {

        jLabel1cp = new javax.swing.JLabel();
        jLabel2cp = new javax.swing.JLabel();
        jLabel3cp = new javax.swing.JLabel();
        jLabel4cp = new javax.swing.JLabel();
        jLabel5cp = new javax.swing.JLabel();
        btchangepass = new javax.swing.JButton();
        tfcpphone = new javax.swing.JTextField();
        tfcpconf = new javax.swing.JPasswordField();
        tfcppassword = new javax.swing.JPasswordField();
        tfcpnewpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1cp.setText("CHANGE PASSWORD");
        getContentPane().add(jLabel1cp);
        jLabel1cp.setBounds(110, 10, 140, 14);

        jLabel2cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2cp.setText("Phone No.");
        getContentPane().add(jLabel2cp);
        jLabel2cp.setBounds(10, 60, 80, 15);

        jLabel3cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3cp.setText("Password");
        getContentPane().add(jLabel3cp);
        jLabel3cp.setBounds(10, 100, 70, 15);

        jLabel4cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4cp.setText("New password");
        getContentPane().add(jLabel4cp);
        jLabel4cp.setBounds(10, 140, 100, 15);

        jLabel5cp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5cp.setText("Confirm pass.");
        getContentPane().add(jLabel5cp);
        jLabel5cp.setBounds(10, 180, 110, 15);

        btchangepass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btchangepass.setText("SUBMIT");
        btchangepass.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btchangepassActionPerformed(evt);
            }
        });
        getContentPane().add(btchangepass);
        btchangepass.setBounds(140, 230, 80, 23);
        getContentPane().add(tfcpphone);
        tfcpphone.setBounds(150, 50, 140, 30);
        getContentPane().add(tfcpconf);
        tfcpconf.setBounds(150, 180, 140, 30);
        getContentPane().add(tfcppassword);
        tfcppassword.setBounds(150, 100, 140, 30);
        getContentPane().add(tfcpnewpass);
        tfcpnewpass.setBounds(150, 140, 140, 30);

        pack();
    }// </editor-fold>                        
  
    private void btchangepassActionPerformed(java.awt.event.ActionEvent evt)                                             
    {                                                 
         String phn, passw, newp, chpass;

            
            phn = tfcpphone.getText();
             passw = tfcppassword.getText();
            newp = tfcpnewpass.getText();
            chpass = tfcpconf.getText();

            if (phn.equals("") || passw.equals("") || newp.equals("") || (chpass.equals("")))
            {
                JOptionPane.showMessageDialog(this, "All Fields are compulsary");
            } else if (phn.length() != 10)
            {
                JOptionPane.showMessageDialog(this, "Mobile no should be 10 digits");
            } else if (!newp.equals(chpass))
            {
                JOptionPane.showMessageDialog(this, "Confirm password is different");
            }  
            else
            {
                try
                {
                    dos.writeBytes("changepass\r\n");
                    dos.writeBytes(phn+"\r\n");
                    dos.writeBytes(passw+"\r\n");
                    dos.writeBytes(newp+"\r\n");
                                     
                    
                } catch (Exception ex)
                {
                   ex.printStackTrace();
                }

            }
    }                                            
 
    // Variables declaration - do not modify                     
    private javax.swing.JButton btchangepass;
    private javax.swing.JLabel jLabel1cp;
    private javax.swing.JLabel jLabel2cp;
    private javax.swing.JLabel jLabel3cp;
    private javax.swing.JLabel jLabel4cp;
    private javax.swing.JLabel jLabel5cp;
    private javax.swing.JPasswordField tfcpconf;
    private javax.swing.JPasswordField tfcpnewpass;
    private javax.swing.JPasswordField tfcppassword;
    private javax.swing.JTextField tfcpphone;
    // End of variables declaration                   
}



public class forgetpass extends javax.swing.JFrame
{
public forgetpass()
    {setLocationRelativeTo(Client.this);
        initComponents();
        setResizable(false);
         setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 400);
        jLabel5fp.setVisible(false);
        jLabel4fp.setVisible(false);
        jLabel3fp.setVisible(false);
        jLabel3cpf.setVisible(false);
        tfcpansff.setVisible(false);
        tfcpnewpassff.setVisible(false);
        tfcpconfffff.setVisible(false);
        btchangepassforg.setVisible(false);
    }
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {

        jLabel1cpf = new javax.swing.JLabel();
        jLabel2cpf = new javax.swing.JLabel();
        jLabel3cpf = new javax.swing.JLabel();
        jLabel4fp = new javax.swing.JLabel();
        jLabel5fp = new javax.swing.JLabel();
        btchangepassforg = new javax.swing.JButton();
        tfcpphonef = new javax.swing.JTextField();
        tfcpconfffff = new javax.swing.JPasswordField();
        tfcpansff = new javax.swing.JPasswordField();
        tfcpnewpassff = new javax.swing.JPasswordField();
        jLabel3fp = new javax.swing.JLabel();
        lbquestion = new javax.swing.JLabel();
        btnextff = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1cpf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1cpf.setText("FORGET PASSWORD");
        getContentPane().add(jLabel1cpf);
        jLabel1cpf.setBounds(110, 10, 140, 14);

        jLabel2cpf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2cpf.setText("Phone No.");
        getContentPane().add(jLabel2cpf);
        jLabel2cpf.setBounds(10, 60, 80, 15);

        jLabel3cpf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3cpf.setText("Security Ques.");
        getContentPane().add(jLabel3cpf);
        jLabel3cpf.setBounds(10, 100, 90, 30);

        jLabel4fp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4fp.setText("New password");
        getContentPane().add(jLabel4fp);
        jLabel4fp.setBounds(10, 190, 100, 15);

        jLabel5fp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5fp.setText("Confirm pass.");
        getContentPane().add(jLabel5fp);
        jLabel5fp.setBounds(10, 230, 110, 15);

        btchangepassforg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btchangepassforg.setText("SUBMIT");
        btchangepassforg.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btchangepassforgActionPerformed(evt);
            }
        });
        getContentPane().add(btchangepassforg);
        btchangepassforg.setBounds(140, 270, 80, 23);
        getContentPane().add(tfcpphonef);
        tfcpphonef.setBounds(150, 50, 140, 30);
        getContentPane().add(tfcpconfffff);
        tfcpconfffff.setBounds(150, 230, 140, 30);
        getContentPane().add(tfcpansff);
        tfcpansff.setBounds(150, 150, 140, 30);
        getContentPane().add(tfcpnewpassff);
        tfcpnewpassff.setBounds(150, 190, 140, 30);

        jLabel3fp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3fp.setText("Security Ans.");
        getContentPane().add(jLabel3fp);
        jLabel3fp.setBounds(10, 140, 90, 30);
        getContentPane().add(lbquestion);
        lbquestion.setBounds(150, 90, 250, 50);

        btnextff.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnextff.setText("NEXT");
        btnextff.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnextffActionPerformed(evt);
            }
        });
        getContentPane().add(btnextff);
        btnextff.setBounds(300, 50, 70, 30);

        pack();
    }// </editor-fold>                        

    private void btchangepassforgActionPerformed(java.awt.event.ActionEvent evt)                                                 
    {                                                     
        // TODO add your handling code here:
        
        
         String phn, passw, newp, chpass;

            
            phn = tfcpphonef.getText();
             passw =tfcpansff.getText();
            newp = tfcpnewpassff.getText();
            chpass = tfcpconfffff.getText();

            if (phn.equals("") || passw.equals("") || newp.equals("") || (chpass.equals("")))
            {
                JOptionPane.showMessageDialog(this, "All Fields are compulsary");
            }  else if (!newp.equals(chpass))
            {
                JOptionPane.showMessageDialog(this, "Confirm password is different");
            }  
            else
            {
                try
                {
                    dos.writeBytes("forgetpass\r\n");
                    dos.writeBytes(phn+"\r\n");
                    dos.writeBytes(passw+"\r\n");
                    dos.writeBytes(newp+"\r\n");
                    
                } catch (Exception ex)
                {
                   
                }

            }
    }                                                

    private void btnextffActionPerformed(java.awt.event.ActionEvent evt)                                         
    {String pno=tfcpphonef.getText();
        if(pno.length()<10)
        {
            JOptionPane.showMessageDialog(this, "Phone no. should be of 10 digit");
        }
else
            {
                try
                {  dos.writeBytes("forgetnext\r\n");
                   dos.writeBytes(pno+"\r\n");
                                    
                    
                } catch (Exception ex)
                {
                   ex.printStackTrace();
                }

            }

    }    

     // Variables declaration - do not modify                     
     javax.swing.JButton btchangepassforg;
     javax.swing.JButton btnextff;
     javax.swing.JLabel jLabel1cpf;
     javax.swing.JLabel jLabel2cpf;
     javax.swing.JLabel jLabel3cpf;
     javax.swing.JLabel jLabel3fp;
     javax.swing.JLabel jLabel4fp;
     javax.swing.JLabel jLabel5fp;
     javax.swing.JLabel lbquestion;
     javax.swing.JPasswordField tfcpansff;
     javax.swing.JPasswordField tfcpconfffff;
     javax.swing.JPasswordField tfcpnewpassff;
     javax.swing.JTextField tfcpphonef;
    // End of variables declaration                   
}


        
    }
        
       





