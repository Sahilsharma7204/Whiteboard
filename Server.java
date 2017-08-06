
import java.awt.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.*;

public class Server extends javax.swing.JFrame
{

    changepassword changepa;
    forgetpass forgetpa;
    ArrayList<Drawing> alDrawing = new ArrayList<>();
    ArrayList<ClientHandler> alStudent = new ArrayList<>();
    StudentTableModel tableModel;
    TeacherDiscussion discussion;
    String teachername;
    WhiteBoard whiteBoard;

    // Below Variable are defined and used for Drawing purpose
    String drawingType = "freehand";
    Color selectedColor = Color.BLACK;
    int stroke = 1;
    boolean isSolid = false;
    String text = "";
    int startXRect = 0;
    int startYRect = 0;
    int heightRect = 0;
    int widthRect = 0;
    SelectShape selectShape = new SelectShape();
    int textX = 0;
    int textY = 0;

    public Server()
    {   setVisible(true);
        setResizable(false);
        setTitle("    TEACHER ");
        tableModel = new StudentTableModel();
        initComponents();
        btsignup.setEnabled(false);
        btlogin.setEnabled(false);
        btchangepassword.setEnabled(false);
        btforgetpassword.setEnabled(false);
        btstartdiscussion.setEnabled(false);
        btnWhiteBoard.setEnabled(false);
        btsendfile.setEnabled(false);
        
        setSize(500, 425);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tablec.setModel(tableModel);
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt1 = new javax.swing.JButton();
        btsignup = new javax.swing.JButton();
        btlogin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablec = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btstartdiscussion = new javax.swing.JButton();
        btsendfile = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        btnWhiteBoard = new javax.swing.JButton();
        btchangepassword = new javax.swing.JButton();
        btforgetpassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bt1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bt1.setText("START SERVER");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(10, 10, 170, 40);

        btsignup.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btsignup.setText("SIGN UP");
        btsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btsignup);
        btsignup.setBounds(10, 70, 79, 30);

        btlogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btlogin.setText("LOGIN ");
        btlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloginActionPerformed(evt);
            }
        });
        getContentPane().add(btlogin);
        btlogin.setBounds(100, 70, 80, 30);

        tablec.setBackground(new java.awt.Color(244, 244, 244));
        tablec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "Student IP"
            }
        ));
        tablec.setToolTipText("");
        tablec.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(tablec);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 30, 220, 320);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("CONNECTED STUDENTS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 150, 15);

        btstartdiscussion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btstartdiscussion.setText("START DISCUSSION");
        btstartdiscussion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btstartdiscussionActionPerformed(evt);
            }
        });
        getContentPane().add(btstartdiscussion);
        btstartdiscussion.setBounds(10, 190, 170, 30);

        btsendfile.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btsendfile.setText("SEND FILE");
        btsendfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsendfileActionPerformed(evt);
            }
        });
        getContentPane().add(btsendfile);
        btsendfile.setBounds(10, 270, 170, 30);

        btnexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit);
        btnexit.setBounds(50, 310, 90, 23);

        btnWhiteBoard.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnWhiteBoard.setText("START WHITEBOARD");
        btnWhiteBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhiteBoardActionPerformed(evt);
            }
        });
        getContentPane().add(btnWhiteBoard);
        btnWhiteBoard.setBounds(10, 230, 170, 30);

        btchangepassword.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btchangepassword.setText("CHANGE PASSWORD");
        btchangepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btchangepasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btchangepassword);
        btchangepassword.setBounds(10, 110, 170, 30);

        btforgetpassword.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btforgetpassword.setText("FORGET PASSWORD");
        btforgetpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btforgetpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btforgetpassword);
        btforgetpassword.setBounds(10, 150, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        btsignup.setEnabled(true);
        btlogin.setEnabled(true);
        btchangepassword.setEnabled(true);
        btforgetpassword.setEnabled(true);
        btstartdiscussion.setEnabled(true);
        btnWhiteBoard.setEnabled(true);
        btsendfile.setEnabled(true);
        bt1.setBackground(Color.red);
        try
        {
            Inner obj = new Inner();
            Thread t2 = new Thread(obj);
            t2.start();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void btsignupActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btsignupActionPerformed
    {//GEN-HEADEREND:event_btsignupActionPerformed

        TeacherS tea = new TeacherS();

    }//GEN-LAST:event_btsignupActionPerformed

    public void openmain()
    {
        this.setVisible(true);

    }
    private void btloginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btloginActionPerformed
    {//GEN-HEADEREND:event_btloginActionPerformed

        TeacherLogin login = new TeacherLogin();


    }//GEN-LAST:event_btloginActionPerformed

    private void btstartdiscussionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btstartdiscussionActionPerformed
    {//GEN-HEADEREND:event_btstartdiscussionActionPerformed
        if (teachername != null)
        {discussion = new TeacherDiscussion();discussion.setVisible(true);
        } else
        {
            JOptionPane.showMessageDialog(this, "Login Required ");
        }


    }//GEN-LAST:event_btstartdiscussionActionPerformed

    private void btsendfileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btsendfileActionPerformed
    {//GEN-HEADEREND:event_btsendfileActionPerformed
       
       
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select File TO Send");
        int n = chooser.showOpenDialog(this);
        if (n == 0)
        {
            File selectedFile = chooser.getSelectedFile();
       
            for (int i = 0; i < alStudent.size(); i++)
            {
                String IP = alStudent.get(i).sock.getInetAddress().toString().substring(1);
                FileSendingClient client = new FileSendingClient(IP, selectedFile);
               
                Thread thread = new Thread(client);
                thread.start();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btsendfileActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnexitActionPerformed
    {//GEN-HEADEREND:event_btnexitActionPerformed
        int exi = JOptionPane.showConfirmDialog(this, "Are you sure to EXIT", "EXIT", JOptionPane.YES_NO_OPTION);
        if (exi == 0)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnWhiteBoardActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnWhiteBoardActionPerformed
    {//GEN-HEADEREND:event_btnWhiteBoardActionPerformed
       if(whiteBoard==null){ whiteBoard = new WhiteBoard();}
       else
       {whiteBoard.setVisible(true);}

    }//GEN-LAST:event_btnWhiteBoardActionPerformed

    private void btchangepasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btchangepasswordActionPerformed
    {//GEN-HEADEREND:event_btchangepasswordActionPerformed
        changepa = new changepassword();

// TODO add your handling code here:
    }//GEN-LAST:event_btchangepasswordActionPerformed

    private void btforgetpasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btforgetpasswordActionPerformed
    {//GEN-HEADEREND:event_btforgetpasswordActionPerformed
        forgetpa = new forgetpass();
        // TODO add your handling code here:
    }//GEN-LAST:event_btforgetpasswordActionPerformed
    class FileSendingClient implements Runnable
    {

        DataInputStream disFile;
        DataOutputStream dosFile;
        File selectedFile;
        Socket socket;

        public FileSendingClient(String ipAddress, File selectedFile)
        {
            try
            {
                this.selectedFile = selectedFile;
                System.out.println(ipAddress);
                socket = new Socket(ipAddress, 10000);
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
                dosFile.writeBytes("getfile\r\n");
                dosFile.writeBytes(selectedFile.getName() + "\r\n");
                dosFile.writeLong(selectedFile.length());
                FileInputStream fis = new FileInputStream(selectedFile);
                byte[] buffer = new byte[1024 * 1024];
                while (true)
                {
                    int r = fis.read(buffer, 0, buffer.length);
                    if (r == -1)
                    {
                        break;
                    }
                    dosFile.write(buffer, 0, r);
                }
                
              
               
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton btchangepassword;
    javax.swing.JButton btforgetpassword;
    javax.swing.JButton btlogin;
    private javax.swing.JButton btnWhiteBoard;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btsendfile;
    private javax.swing.JButton btsignup;
    private javax.swing.JButton btstartdiscussion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablec;
    // End of variables declaration//GEN-END:variables

    class Inner implements Runnable
    {

        public void run()
        {
            try
            {
                ServerSocket sersock = new ServerSocket(9000);
                bt1.setText("SERVER STARTED");
                System.out.println("Server is Started at 9000");
                while (true)
                {
                    Socket sock = sersock.accept();
                    System.out.println("Connection Accepted");
                    ClientHandler cl = new ClientHandler(sock);
                    Thread t1 = new Thread(cl);
                    t1.start();
                }
            } catch (Exception e)
            {
                if (e.toString().toLowerCase().contains("already in use"))
                {
                    JOptionPane.showMessageDialog(Server.this, "Server Already Working ");
                }
            }
        }
    }

    class ClientHandler implements Runnable
    {

        String studentName;
        Socket sock;
        String request;
        DataInputStream dis;
        DataOutputStream dos;

        ClientHandler(Socket sock)
        {
            try
            {
                this.sock = sock;
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        public void run()
        {
            try
            {
                while (true)
                {
                    request = dis.readLine();
                    if (request.equals("student_signup"))
                    {
                        String name = dis.readLine();
                        String email = dis.readLine();
                        String mob = dis.readLine();
                        String secQues = dis.readLine();
                        String secAns = dis.readLine();
                        String password = dis.readLine();

                        try
                        {
                            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("select * from student");
                            rs.moveToInsertRow();
                            rs.updateString("name", name);
                            rs.updateString("phone", mob);
                            rs.updateString("email", email);
                            rs.updateString("sec_ques", secQues);
                            rs.updateString("sec_ans", secAns);
                            rs.updateString("password", password);
                            rs.insertRow();
                            rs.close();
                            stmt.close();
                            con.close();
                            dos.writeBytes("signup_true\r\n");
                        } catch (Exception e)
                        {
                            dos.writeBytes("signup_false\r\n");
                            e.printStackTrace();
                        }
                    } else if (request.equals("student_login"))
                    {
                        String mob = dis.readLine();
                        String pass = dis.readLine();
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from student where phone='" + mob + "'and password='" + pass + "'");
                        if (rs.next())
                        {
                            dos.writeBytes("login_true\r\n");
                            studentName = rs.getString("name");
                            alStudent.add(this);
                            tableModel.fireTableDataChanged();
                        } else
                        {
                            dos.writeBytes("login_false\r\n");
                        }

                    } else if (request.equals("message"))
                    {
                        String message = dis.readLine();
                        discussion.jTextArea1.append(studentName + " : " + message + "\n");
                    } else if (request.equals("changepass"))
                    {
                        String phn, passw, newp;

                        phn = dis.readLine();
                        passw = dis.readLine();
                        newp = dis.readLine();

                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        ResultSet rs = stmt.executeQuery("select * from student where phone = '" + phn + "'and password = '" + passw + "'");

                        if (rs.next())
                        {
                            rs.updateString("password", newp);
                            rs.updateRow();
                            dos.writeBytes("changetrue\r\n");

                        } else
                        {
                            dos.writeBytes("changefalse\r\n");
                        }

                        rs.close();
                        stmt.close();
                        con.close();

                    } else if (request.equals("forgetnext"))
                    {String pno = dis.readLine();
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        ResultSet rs = stmt.executeQuery("select * from student where phone = '" + pno + "'");
                        if (rs.next())
                        {
                            String quess = rs.getString("sec_ques");
                            dos.writeBytes("forgetques\r\n");
                            dos.writeBytes(quess + "\r\n");
                        } else
                        {
                            dos.writeBytes("forgetnodata\r\n");
                        }

                    }else if (request.equals("forgetpass"))
                    {
                      String phn, passw, newp;

                        phn = dis.readLine();
                        passw = dis.readLine();
                        newp = dis.readLine();

                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        ResultSet rs = stmt.executeQuery("select * from student where phone = '" + phn + "'and sec_ans = '" + passw + "'");

                        if (rs.next())
                        {
                            rs.updateString("password", newp);
                            rs.updateRow();
                            dos.writeBytes("forgettrue\r\n");

                        } else
                        {
                            dos.writeBytes("forgetfalse\r\n");
                        }

                        rs.close();
                        stmt.close();
                        con.close();

                    }
                    

                }
            } catch (Exception e)
            {
                alStudent.remove(this);
                tableModel.fireTableDataChanged();
            }
        }

    }

    public class TeacherS extends javax.swing.JFrame
    {

        public TeacherS()
        {
            initComponents();
            setLocationRelativeTo(Server.this);
            setResizable(false);
            setSize(400, 600);
            setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jLabel1 = new javax.swing.JLabel();
            tfemail = new javax.swing.JTextField();
            tfname = new javax.swing.JTextField();
            signup = new javax.swing.JButton();
            pppppp = new javax.swing.JLabel();
            eeeee = new javax.swing.JLabel();
            ppppppppppp = new javax.swing.JLabel();
            nnnnn = new javax.swing.JLabel();
            tfpassword = new javax.swing.JPasswordField();
            tfseq_ques = new javax.swing.JTextField();
            tfseq_ans = new javax.swing.JTextField();
            sssss = new javax.swing.JLabel();
            ssssssss = new javax.swing.JLabel();
            tfmob = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel1.setText("Signup");
            getContentPane().add(jLabel1);
            jLabel1.setBounds(170, 20, 120, 30);
            getContentPane().add(tfemail);
            tfemail.setBounds(110, 190, 220, 30);
            getContentPane().add(tfname);
            tfname.setBounds(110, 90, 220, 30);

            signup.setText("Sign Up");
            signup.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    signupActionPerformed(evt);
                }
            });
            getContentPane().add(signup);
            signup.setBounds(150, 400, 140, 40);

            pppppp.setText("Password");
            getContentPane().add(pppppp);
            pppppp.setBounds(10, 240, 90, 20);

            eeeee.setText("e-mail");
            getContentPane().add(eeeee);
            eeeee.setBounds(10, 190, 90, 20);

            ppppppppppp.setText("Phone-No.");
            getContentPane().add(ppppppppppp);
            ppppppppppp.setBounds(10, 140, 70, 20);

            nnnnn.setText("Name");
            getContentPane().add(nnnnn);
            nnnnn.setBounds(14, 94, 70, 20);
            getContentPane().add(tfpassword);
            tfpassword.setBounds(110, 240, 220, 30);

            getContentPane().add(tfseq_ques);
            tfseq_ques.setBounds(110, 290, 220, 30);
            getContentPane().add(tfseq_ans);
            tfseq_ans.setBounds(110, 340, 220, 30);

            sssss.setText("Security Ques.");
            getContentPane().add(sssss);
            sssss.setBounds(10, 290, 80, 20);

            ssssssss.setText("Security Ans.");
            getContentPane().add(ssssssss);
            ssssssss.setBounds(10, 340, 90, 20);
            getContentPane().add(tfmob);
            tfmob.setBounds(110, 140, 220, 30);

            pack();
        }// </editor-fold>                        

        private void signupActionPerformed(java.awt.event.ActionEvent evt)
        {
            String name, phn, emn, passw, sec, seqans;

            name = tfname.getText();
            phn = tfmob.getText();
            emn = tfemail.getText();
            passw = tfpassword.getText();
            sec = tfseq_ques.getText();
            seqans = tfseq_ans.getText();

            if (name.equals("") || phn.equals("") || emn.equals("") || sec.equals("") || seqans.equals("") || (passw.equals("")))
            {
                JOptionPane.showMessageDialog(this, "All Fields are compulsary");
            } else if (phn.length() != 10)
            {
                JOptionPane.showMessageDialog(this, "Mobile no should be 10 digits");
            } else
            {
                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from teacher");
                    String a = tfname.getText();
                    String b = tfmob.getText();
                    String c = tfemail.getText();
                    String d = tfpassword.getText();
                    String e = tfseq_ques.getText();
                    String f = tfseq_ans.getText();

                    rs.moveToInsertRow();
                    rs.updateString("Name", a);
                    rs.updateString("Mobile_no", b);
                    rs.updateString("email", c);
                    rs.updateString("Password", d);
                    rs.updateString("seq_ques", e);
                    rs.updateString("seq_ans", f);
                    rs.insertRow();

                    rs.close();
                    stmt.close();
                    con.close();
                    JOptionPane.showMessageDialog(this, "Sign up Successful");
                    tfname.setText("");
                    tfmob.setText("");
                    tfemail.setText("");
                    tfpassword.setText("");
                    tfseq_ques.setText("");
                    tfseq_ans.setText("");
                    this.setVisible(false);
                    openmain();

                } catch (Exception ex)
                {
                    if (ex.toString().toLowerCase().contains("duplicate entry"))
                    {
                        JOptionPane.showMessageDialog(this, "Phone Already Registered");
                    }
                }

            }
        }

        private javax.swing.JLabel eeeee;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel nnnnn;
        private javax.swing.JLabel pppppp;
        private javax.swing.JLabel ppppppppppp;
        private javax.swing.JButton signup;
        private javax.swing.JLabel sssss;
        private javax.swing.JLabel ssssssss;
        private javax.swing.JTextField tfemail;
        private javax.swing.JTextField tfmob;
        private javax.swing.JTextField tfname;
        private javax.swing.JPasswordField tfpassword;
        private javax.swing.JTextField tfseq_ans;
        private javax.swing.JTextField tfseq_ques;
        // End of variables declaration                   
    }

    public class TeacherLogin extends javax.swing.JFrame
    {

        public TeacherLogin()
        {
            initComponents();
             setLocationRelativeTo(Server.this);
            setResizable(false);
            setVisible(true);
            setSize(400, 400);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            pfpassword_login = new javax.swing.JPasswordField();
            tfmob_login = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            teacherloginbt = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            jLabel1.setText("MOBILE NO.");
            getContentPane().add(jLabel1);
            jLabel1.setBounds(40, 76, 74, 14);

            jLabel2.setText("PASSWORD");
            getContentPane().add(jLabel2);
            jLabel2.setBounds(40, 127, 62, 14);
            getContentPane().add(pfpassword_login);
            pfpassword_login.setBounds(152, 124, 160, 30);
            getContentPane().add(tfmob_login);
            tfmob_login.setBounds(152, 73, 160, 30);

            jLabel3.setForeground(new java.awt.Color(250, 0, 0));
            jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
            jLabel3.setText("TEACHER LOGIN ");
            getContentPane().add(jLabel3);
            jLabel3.setBounds(115, 10, 150, 30);

            teacherloginbt.setText("LOGIN");
            teacherloginbt.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    teacherloginbtActionPerformed(evt);
                }
            });
            getContentPane().add(teacherloginbt);
            teacherloginbt.setBounds(110, 250, 140, 40);

            pack();
        }// </editor-fold>                        

        private void teacherloginbtActionPerformed(java.awt.event.ActionEvent evt)
        {
            try
            {

                String mob = tfmob_login.getText();
                String pass = new String(pfpassword_login.getPassword());
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from teacher where Mobile_no = '" + mob + "'and Password = '" + pass + "'");
                if (rs.next())
                {
                    teachername = rs.getString("Name");
                    JOptionPane.showMessageDialog(this, "Login Successful");
                    teacherloginbt.setEnabled(false);
                    btlogin.setEnabled(false);
                    this.setVisible(false);
                    openmain();

                } else
                {
                    JOptionPane.showMessageDialog(this, "Login Failed");
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        // Variables declaration - do not modify                     
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPasswordField pfpassword_login;
        private javax.swing.JButton teacherloginbt;
        private javax.swing.JTextField tfmob_login;
        // End of variables declaration                   
    }

    class StudentTableModel extends AbstractTableModel
    {

        @Override
        public int getRowCount()
        {
            return alStudent.size();
        }

        @Override
        public int getColumnCount()
        {
            return 2;
        }

        @Override
        public Object getValueAt(int i, int j)
        {
            if (j == 0)
            {
                return alStudent.get(i).studentName;
            } else
            {
                return alStudent.get(i).sock.getRemoteSocketAddress().toString();
            }
        }

        @Override
        public String getColumnName(int i)
        {
            if (i == 0)
            {
                return "Name";
            } else
            {
                return "IP Address";
            }
        }
    }

    public class TeacherDiscussion extends javax.swing.JFrame
    {

        StudentListModel listModel;

        public TeacherDiscussion()
        {
            initComponents();
             setLocationRelativeTo(Server.this);
            listModel = new StudentListModel();
            listclient.setModel(listModel);
            setVisible(true);
            setSize(600, 520);
            jTextArea1.setFocusable(false);
            tfmessage.requestFocus();
        }

        private void initComponents()
        {

            jScrollPane1 = new javax.swing.JScrollPane();
            jTextArea1 = new javax.swing.JTextArea();
            tfmessage = new javax.swing.JTextField();
            listclient = new javax.swing.JList();
            btsend = new javax.swing.JButton();
            btbroad = new javax.swing.JButton();
            labelconnectedstud = new javax.swing.JLabel();

             getContentPane().setLayout(null);

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane1.setViewportView(jTextArea1);

            getContentPane().add(jScrollPane1);
            jScrollPane1.setBounds(10, 20, 340, 330);
            getContentPane().add(tfmessage);
            tfmessage.setBounds(10, 390, 340, 40);
            getContentPane().add(listclient);
            listclient.setBounds(390, 20, 160, 330);

            btsend.setText("SEND");
            btsend.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btsendActionPerformed(evt);
                }
            });
            getContentPane().add(btsend);
            btsend.setBounds(379, 390, 80, 40);

            btbroad.setText("BROADCAST");
            btbroad.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btbroadActionPerformed(evt);
                }
            });
            getContentPane().add(btbroad);
            btbroad.setBounds(470, 390, 110, 40);
            labelconnectedstud.setText("Connected Students");
            getContentPane().add(labelconnectedstud);
            labelconnectedstud.setBounds(420, 0, 130, 20);
            pack();
        }// </editor-fold>                        

        private void btsendActionPerformed(java.awt.event.ActionEvent evt)
        {  
            try
            {
                String messagediscussion = tfmessage.getText().trim();
                if (messagediscussion.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "Please Type Message ");
                    return;
                }
                int indexofselected = -1;
                indexofselected = listclient.getSelectedIndex();
                if (indexofselected == -1)
                {
                    JOptionPane.showMessageDialog(this, "Please Select Student");
                    return;
                }
                alStudent.get(indexofselected).dos.writeBytes("message\r\n");
                alStudent.get(indexofselected).dos.writeBytes(teachername + "\r\n");
                alStudent.get(indexofselected).dos.writeBytes(messagediscussion + "\r\n");
                jTextArea1.append("You to " + alStudent.get(indexofselected).studentName + " :" + messagediscussion + "\r\n");
                tfmessage.requestFocus();
                tfmessage.setText("");
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }

        private void btbroadActionPerformed(java.awt.event.ActionEvent evt)
        {      
            try
            {
                String messagediscussion = tfmessage.getText().trim();
                if (messagediscussion.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "Please Type Message ");
                    return;
                }
                for (int i = 0; i < alStudent.size(); i++)
                {
                    alStudent.get(i).dos.writeBytes("message\r\n");
                    alStudent.get(i).dos.writeBytes(teachername + "\r\n");
                    alStudent.get(i).dos.writeBytes(messagediscussion + "\r\n");
                }
                jTextArea1.append("You to ALL    :" + messagediscussion + "\r\n");
                tfmessage.requestFocus();
                tfmessage.setText("");
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }

        private javax.swing.JButton btbroad;
        private javax.swing.JButton btsend;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JList listclient;
        private javax.swing.JTextField tfmessage;
        private javax.swing.JLabel labelconnectedstud;
        // End of variables declaration                   
    }

    class StudentListModel extends AbstractListModel<String>
    {

        @Override
        public int getSize()
        {
            return alStudent.size();
        }

        @Override
        public String getElementAt(int index)
        {
            return alStudent.get(index).studentName;
        }

    }

    public class FileProgressBar extends javax.swing.JFrame
    {

        public FileProgressBar(String fileName, int totalStudents)
        {
            initComponents();
            setAlwaysOnTop(true);
            setVisible(true);
            lbFileName.setText("Sending file : " + fileName);
            pbar.setMaximum(totalStudents);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            pbar = new javax.swing.JProgressBar();
            lbFileName = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setUndecorated(true);

            lbFileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lbFileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbFileName.setText("jLabel1");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pbar, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                                    .addComponent(lbFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pbar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>                        

        // Variables declaration - do not modify                     
        private javax.swing.JLabel lbFileName;
        public javax.swing.JProgressBar pbar;
        // End of variables declaration                   
    }

    class WhiteBoard extends javax.swing.JFrame
    {

        public WhiteBoard()
        { setLocationRelativeTo(Server.this);
            initComponents();
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);
            setSize(650, 500);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jMenuBar1 = new javax.swing.JMenuBar();
            mOption = new javax.swing.JMenu();
            miClearAll = new javax.swing.JMenuItem();
            miSelectShape = new javax.swing.JMenuItem();
            miSetStroke = new javax.swing.JMenuItem();
            miSetColor = new javax.swing.JMenuItem();
            miback = new javax.swing.JMenuItem();
            addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
            {
                public void mouseDragged(java.awt.event.MouseEvent evt)
                {
                    formMouseDragged(evt);
                }
            });
            addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mousePressed(java.awt.event.MouseEvent evt)
                {
                    formMousePressed(evt);
                }

                public void mouseReleased(java.awt.event.MouseEvent evt)
                {
                    formMouseReleased(evt);
                }
            });

            mOption.setText("White Board Options");

            miClearAll.setText("Clear All");
            miClearAll.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    miClearAllActionPerformed(evt);
                }
            });
            mOption.add(miClearAll);

            miSelectShape.setText("Select Shape");
            miSelectShape.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    miSelectShapeActionPerformed(evt);
                }
            });
            mOption.add(miSelectShape);

            miSetStroke.setText("Set Stroke");
            miSetStroke.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    miSetStrokeActionPerformed(evt);
                }
            });
            mOption.add(miSetStroke);
           

            miSetColor.setText("Set Color");
            miSetColor.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    miSetColorActionPerformed(evt);
                }
            });
            mOption.add(miSetColor); mOption.add(miback);
            miback.setText("Back");
            miback.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    mibackActionPerformed(evt);
                }
            });

            jMenuBar1.add(mOption);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 771, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 416, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>                    

        private void formMousePressed(java.awt.event.MouseEvent evt)
        {
            startXRect = evt.getX();
            startYRect = evt.getY();
            if (drawingType.equals("text"))
            {
                textX = evt.getX();
                textY = evt.getY();
                text = JOptionPane.showInputDialog(whiteBoard, "Input Text", "Input Text", JOptionPane.QUESTION_MESSAGE);
                alDrawing.add(new Drawing(drawingType, textX, textY, 0, 0, stroke, selectedColor, isSolid, text));
                repaint();
            }
        }

        private void formMouseReleased(java.awt.event.MouseEvent evt)
        {
            alDrawing.add(new Drawing(drawingType, 0, 0, 0, 0, stroke, selectedColor, isSolid, text));
            if (drawingType.equals("rect"))
            {
                alDrawing.add(new Drawing(drawingType, startXRect, startYRect, widthRect, heightRect, stroke, selectedColor, isSolid, text));
                repaint();
            } else if (drawingType.equals("circle"))
            {
                alDrawing.add(new Drawing(drawingType, startXRect, startYRect, widthRect, heightRect, stroke, selectedColor, isSolid, text));
                repaint();
            } else if (drawingType.equals("square"))
            {
                alDrawing.add(new Drawing(drawingType, startXRect, startYRect, widthRect, heightRect, stroke, selectedColor, isSolid, text));
                repaint();
            }
        }

        private void formMouseDragged(java.awt.event.MouseEvent evt)
        {
            try
            {
                if (drawingType.equals("freehand"))
                {
                    int startX = evt.getX();
                    int startY = evt.getY();
                    alDrawing.add(new Drawing(drawingType, startX, startY, startX, startY, stroke, selectedColor, isSolid, text));
                } else if (drawingType.equals("rect"))
                {
                    int endX = evt.getX();
                    int endY = evt.getY();
                    widthRect = endX - startXRect;
                    heightRect = endY - startYRect;
                } else if (drawingType.equals("circle"))
                {
                    int endX = evt.getX();
                    int endY = evt.getY();
                    widthRect = endX - startXRect;
                    heightRect = widthRect;
                } else if (drawingType.equals("square"))
                {
                    int endX = evt.getX();
                    int endY = evt.getY();
                    widthRect = endX - startXRect;
                    heightRect = widthRect;
                }
                repaint();
            } catch (Exception ex)
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void miClearAllActionPerformed(java.awt.event.ActionEvent evt)
        {
            alDrawing.clear();
            repaint();
        }

        private void mibackActionPerformed(java.awt.event.ActionEvent evt)
        {
            openmain();
            this.setVisible(false);
        }

        private void miSelectShapeActionPerformed(java.awt.event.ActionEvent evt)
        {
            Object[] button =
            {
                "Select Shape", "Dismiss"
            };
            int n = JOptionPane.showOptionDialog(whiteBoard, selectShape, "Select Shape", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, button[0]);
            if (n == 0)
            {
                if (selectShape.rbFreehand.isSelected())
                {
                    drawingType = "freehand";
                } else if (selectShape.rbCircle.isSelected())
                {
                    drawingType = "circle";
                    int i = JOptionPane.showConfirmDialog(whiteBoard, "Fill Circle?", "WhiteBoard", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (i == 0)
                    {
                        isSolid = true;
                    } else
                    {
                        isSolid = false;
                    }
                } else if (selectShape.rbRectangle.isSelected())
                {
                    drawingType = "rect";
                    int i = JOptionPane.showConfirmDialog(whiteBoard, "Fill Rectangle?", "WhiteBoard", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (i == 0)
                    {
                        isSolid = true;
                    } else
                    {
                        isSolid = false;
                    }
                } else if (selectShape.rbSquare.isSelected())
                {
                    drawingType = "square";
                    int i = JOptionPane.showConfirmDialog(whiteBoard, "Fill Square?", "WhiteBoard", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (i == 0)
                    {
                        isSolid = true;
                    } else
                    {
                        isSolid = false;
                    }
                } else if (selectShape.rbText.isSelected())
                {
                    drawingType = "text";
                    isSolid = false;
                }
            }
        }

        private void miSetStrokeActionPerformed(java.awt.event.ActionEvent evt)
        {
            String num = JOptionPane.showInputDialog(whiteBoard, "Set Stroke", "Stroke", JOptionPane.QUESTION_MESSAGE);
            stroke = Integer.parseInt(num);
        }

        private void miSetColorActionPerformed(java.awt.event.ActionEvent evt)
        {
            selectedColor = JColorChooser.showDialog(whiteBoard, "Select Color", selectedColor);
           
        }

        // Variables declaration - do not modify                     
        private javax.swing.JMenuBar jMenuBar1;
        private javax.swing.JMenu mOption;
        private javax.swing.JMenuItem miClearAll;
        private javax.swing.JMenuItem miSelectShape;
        private javax.swing.JMenuItem miSetColor;
        private javax.swing.JMenuItem miSetStroke;
        private javax.swing.JMenuItem miback;
        // End of variables declaration                   

        @Override
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
                    for (int lino = 0; lino < alDrawing.get(i).stroke; lino++)
                    {
                        g.drawLine(startX + lino, startY + lino, endX + lino, endY + lino);

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
                    {
                        for (int lino = 0; lino < alDrawing.get(i).stroke; lino++)
                        {
                            g.drawRect(startX + lino, startY + lino, width - 2 * lino, height - 2 * lino);
                        }
                    }
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
                    {
                        for (int lino = 0; lino < alDrawing.get(i).stroke; lino++)
                        {
                            g.drawOval(startX + lino, startY + lino, width - 2 * lino, height - 2 * lino);
                        }
                    }
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
                    {
                        for (int lino = 0; lino < alDrawing.get(i).stroke; lino++)
                        {
                            g.drawRect(startX + lino, startY +lino, width - 2 * lino, height - 2 * lino);
                        }
                    }
                } else if (alDrawing.get(i).shapeType.equals("text"))
                {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    g.drawString(alDrawing.get(i).text, startX, startY);
                }
            }
            try
            {
                for (int i = 0; i < alStudent.size(); i++)
                {
                    alStudent.get(i).dos.writeBytes("drawing\r\n");
                    alStudent.get(i).dos.writeInt(alDrawing.size());
                    for (int j = 0; j < alDrawing.size(); j++)
                    {
                        alStudent.get(i).dos.writeBytes(alDrawing.get(j).shapeType + "\r\n");
                        alStudent.get(i).dos.writeInt(alDrawing.get(j).startingX);
                        alStudent.get(i).dos.writeInt(alDrawing.get(j).startingY);
                        alStudent.get(i).dos.writeInt(alDrawing.get(j).endingX);
                        alStudent.get(i).dos.writeInt(alDrawing.get(j).endingY);
                        alStudent.get(i).dos.writeInt(alDrawing.get(j).selectedColor.getRed());
                        alStudent.get(i).dos.writeInt(alDrawing.get(j).selectedColor.getGreen());
                        alStudent.get(i).dos.writeInt(alDrawing.get(j).selectedColor.getBlue());
                        alStudent.get(i).dos.writeInt(alDrawing.get(j).stroke);
                        alStudent.get(i).dos.writeBoolean(alDrawing.get(j).isSolid);
                        alStudent.get(i).dos.writeBytes(alDrawing.get(j).text + "\r\n");
                    }
                }
            } catch (Exception e)
            {
                e.printStackTrace();
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
        int stroke;
        Color selectedColor;
        boolean isSolid;
        String text;

        public Drawing(String shapeType, int startingX, int startingY, int endingX, int endingY, int stroke, Color selectedColor, boolean isSolid, String text)
        {
            this.shapeType = shapeType;
            this.startingX = startingX;
            this.startingY = startingY;
            this.endingX = endingX;
            this.endingY = endingY;
            this.stroke = stroke;
            this.selectedColor = selectedColor;
            this.isSolid = isSolid;
            this.text = text;
        }
    }

    public class SelectShape extends javax.swing.JPanel
    {

        public SelectShape()
        {
            initComponents();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            btngrpShape = new javax.swing.ButtonGroup();
            jLabel1 = new javax.swing.JLabel();
            rbFreehand = new javax.swing.JRadioButton();
            rbRectangle = new javax.swing.JRadioButton();
            rbCircle = new javax.swing.JRadioButton();
            rbSquare = new javax.swing.JRadioButton();
            rbText = new javax.swing.JRadioButton();

            btngrpShape.add(rbCircle);
            btngrpShape.add(rbFreehand);
            btngrpShape.add(rbRectangle);
            btngrpShape.add(rbSquare);
            btngrpShape.add(rbText);

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel1.setText("Select Shape");

            rbFreehand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            rbFreehand.setText("Freehand");

            rbRectangle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            rbRectangle.setText("Rectangle");

            rbCircle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            rbCircle.setText("Circle");

            rbSquare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            rbSquare.setText("Square");

            rbText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            rbText.setText("Text");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(rbText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbFreehand, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(rbSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(295, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbFreehand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rbCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(239, Short.MAX_VALUE))
            );
        }// </editor-fold>                        

        // Variables declaration - do not modify                     
        private javax.swing.ButtonGroup btngrpShape;
        private javax.swing.JLabel jLabel1;
        public javax.swing.JRadioButton rbCircle;
        public javax.swing.JRadioButton rbFreehand;
        public javax.swing.JRadioButton rbRectangle;
        public javax.swing.JRadioButton rbSquare;
        public javax.swing.JRadioButton rbText;
    // End of variables declaration                   
    }

    public class changepassword extends javax.swing.JFrame
    {

        public changepassword()
        {setResizable(false);
            initComponents();
             setLocationRelativeTo(Server.this);
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
            } else
            {
                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ResultSet rs = stmt.executeQuery("select * from teacher where mobile_no = '" + phn + "'and password = '" + passw + "'");
                    if (rs.next())
                    {
                        rs.updateString("password", newp);
                        rs.updateRow();
                        JOptionPane.showMessageDialog(this, "Password Changed");

                        this.setVisible(false);
                        openmain();

                    } else
                    {
                        JOptionPane.showMessageDialog(this, "Invalid User");
                    }

                    rs.close();
                    stmt.close();
                    con.close();

                } catch (Exception ex)
                {

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
        {setResizable(false);
            initComponents();
             setLocationRelativeTo(Server.this);
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
            passw = tfcpansff.getText();
            newp = tfcpnewpassff.getText();
            chpass = tfcpconfffff.getText();

            if (phn.equals("") || passw.equals("") || newp.equals("") || (chpass.equals("")))
            {
                JOptionPane.showMessageDialog(this, "All Fields are compulsary");
            } else if (!newp.equals(chpass))
            {
                JOptionPane.showMessageDialog(this, "Confirm password is different");
            } else
            {
                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ResultSet rs = stmt.executeQuery("select * from teacher where mobile_no = '" + phn + "'and seq_ans = '" + passw + "'");
                    if (rs.next())
                    {
                        rs.updateString("password", newp);
                        rs.updateRow();
                        JOptionPane.showMessageDialog(this, "Password Changed");

                        this.setVisible(false);
                        openmain();

                    } else
                    {
                        JOptionPane.showMessageDialog(this, "Wrong Answer");
                    }

                    rs.close();
                    stmt.close();
                    con.close();

                } catch (Exception ex)
                {

                }

            }
        }

        private void btnextffActionPerformed(java.awt.event.ActionEvent evt)
        {
            String pno = tfcpphonef.getText();
            if (pno.length() < 10)
            {
                JOptionPane.showMessageDialog(this, "Phone no. should be of 10 digit");
            } else
            {
                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/white_board", "root", "password");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ResultSet rs = stmt.executeQuery("select * from teacher where mobile_no = '" + pno + "'");
                    if (rs.next())
                    {
                        String ques = rs.getString("seq_ques");
                        jLabel5fp.setVisible(true);
                        jLabel4fp.setVisible(true);
                        jLabel3fp.setVisible(true);
                        jLabel3cpf.setVisible(true);
                        tfcpansff.setVisible(true);
                        tfcpnewpassff.setVisible(true);
                        tfcpconfffff.setVisible(true);
                        btchangepassforg.setVisible(true);
                        lbquestion.setText(ques + "  ?");

                    } else
                    {
                        JOptionPane.showMessageDialog(this, "Invalid User");
                    }

                    rs.close();
                    stmt.close();
                    con.close();

                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }

            }

        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton btchangepassforg;
        private javax.swing.JButton btnextff;
        private javax.swing.JLabel jLabel1cpf;
        private javax.swing.JLabel jLabel2cpf;
        private javax.swing.JLabel jLabel3cpf;
        private javax.swing.JLabel jLabel3fp;
        private javax.swing.JLabel jLabel4fp;
        private javax.swing.JLabel jLabel5fp;
        private javax.swing.JLabel lbquestion;
        private javax.swing.JPasswordField tfcpansff;
        private javax.swing.JPasswordField tfcpconfffff;
        private javax.swing.JPasswordField tfcpnewpassff;
        private javax.swing.JTextField tfcpphonef;
    // End of variables declaration                   
    }

}
