/*
 * =============================
 * HISTÓRICO DE VERSÕES
 * =============================
 * 
 * Versão 2.1.25:
 * - Adicionado menu suspenso "Configurações" com opções de tema claro/escuro
 * - Permite alterar tipo e tamanho da fonte
 * - Implementado botão "=" ocupando 2 linhas (GridBagLayout)
 * - Reorganizados os botões "0" na segunda coluna e "." na terceira
 * - Adicionada caixa de texto para histórico de operações
 * - Corrigido funcionamento do botão "CE" para apagar último caractere
 * - Corrigido suporte à tecla Backspace/Delete do teclado
 * - Adicionado suporte completo ao modo escuro e claro com destaque visual no menu
 * 
 * Versão 1.1.25:
 * - Interface gráfica com botões numéricos e operacionais
 * - Suporte ao teclado físico para digitação dos números e operações
 * - Campo de texto para exibição do resultado
 * - Lógica básica de cálculo com armazenamento do primeiro número e operação
 * 
 * Versao 2.2.25 
 * - Adiciona a operação ao histórico
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * =============================
 * CLASSE CALCULADORA 1.1.25
 * =============================
 */
public class TelaCalculadora extends JFrame implements ActionListener, KeyListener {
    /*
    * =============================
    *   VARIAVEIS DA CLASSE 
    * =============================
    *   1.1.25 - 
    *       tela - Campo de texto para exibir os números e resultados
    *       operacao - Variável para armazenar a operação selecionada +,-,*,/
    *       primeiroNumero - Variável para armazenar o primeiro número digitado
    *       novaEntrada - Flag para indicar se é uma nova entrada de número
    *       servicos - Classe que faz o cálculo
    *   2.1.25 -
    *     historicoArea - Caixa de texto para exibir o histórico
    *     modoEscuro - Flag que indica se o modo escuro está ativado
    *     modoClaroItem, modoEscuroItem - Itens de menu para alternância de tema
    *
    *   2.2.25 - Alterando o historico para ser exibido no painel superior
    *
    *   2.3.25 - Modifica o botão para borda arredondada
    *
    *   2.4.25 - Adiciona a % operação de porcentagem
    * =============================
    */
    private JTextField tela; // Campo de texto para exibir os números e resultados
    private String operacao; // Variável para armazenar a operação selecionada +,-,*,/
    private double primeiroNumero = 0; // Variável para armazenar o primeiro número digitado
    private boolean novaEntrada = true; // Flag para indicar se é uma nova entrada de número
    private final ServicosDaCalculadora servicos = new ServicosDaCalculadora(); //Classe que faz o calculo
    private boolean modoEscuro = false; // Flag que indica se o modo escuro está ativado
    private JMenuItem modoClaroItem, modoEscuroItem; // Itens de menu para alternância de tema
    private JTextArea historicoArea; // Caixa de texto para exibir o histórico de operações
    /*
     * =============================
     * CONSTRUTOR DA CLASSE
     * =============================
     * 1.1.25 - Inicializa a janela, a tela de exibição e os botões
     * 2.1.25 - Adiciona histórico, suporte a GridBagLayout e configurações visuais
     */
    public TelaCalculadora() {
        setTitle("Calculadora 2.4.25"); 
        setSize(450, 700); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); 

        //2.1.25 - Chama o menu de configurações
        CriarMenu();

        // 1.1.25 - Cria o campo de texto para exibir os números e resultados
        tela = new JTextField();
        tela.setFont(new Font("Arial", Font.PLAIN, 40)); 
        tela.setEditable(false);
        tela.setHorizontalAlignment(SwingConstants.RIGHT); 
        add(tela, BorderLayout.NORTH); 

        // 2.1.25 - Define o tamanho preferido do campo de texto
        tela.setPreferredSize(new Dimension(400, 100)); 

        // 2.1.25 - Historico de operações
        historicoArea = new JTextArea();
        historicoArea.setEditable(false);
        historicoArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        JScrollPane scroll = new JScrollPane(historicoArea);
        scroll.setPreferredSize(new Dimension(400, 100)); 
        
        //2.2.25
        historicoArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        historicoArea.setAlignmentX(RIGHT_ALIGNMENT);
        scroll.setPreferredSize(new Dimension(150,100));

        //2.2.25 - Adiciona o histórico ao painel superior
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BorderLayout());
        painelSuperior.add(scroll, BorderLayout.NORTH);
        painelSuperior.add(tela, BorderLayout.CENTER);
        add(painelSuperior, BorderLayout.NORTH);

        // 1.1.25 - Painel de botões
        JPanel botoes = new JPanel(new GridBagLayout());
        // 2.1.25 - Correção do layout para GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Preenche o espaço disponível
        gbc.weightx = 1.0; // Distribui o espaço horizontalmente
        gbc.weighty = 1.0; // Distribui o espaço verticalmente
        gbc.ipadx = 10;
        gbc.ipady = 10;
        String[][] botoesTexto = {
            {"C", "CE", "%", "*"}, 
            {"7", "8", "9", "/"},
            {"4", "5", "6", "+"},
            {"1", "2", "3", "-"},
            {"",  "0", ".", "="}
        };


        /*
         *   1.1.25 - Adiciona os botões ao painel de botões
         *       Cada botão é criado com o texto correspondente e um ActionListener para capturar os cliques
         *       O ActionListener chama o método actionPerformed quando o botão é clicado
         * 
         *   2.1.25 - Adiciona suporte ao GridBagLayout para melhor organização dos botões
         */
        for (int i = 0; i < botoesTexto.length; i++) {
            for (int j = 0; j <botoesTexto[i].length; j++) {
                String texto = botoesTexto[i][j];
                if (!texto.isEmpty()) {
                    gbc.gridx = j; // Define a coluna do botão
                    gbc.gridy = i; // Define a linha do botão
                    //JButton btn = new JButton(texto);
                    //btn.setFont(new Font("Arial", Font.BOLD, 20));
                    //btn.addActionListener(this);
                    // 2.3.25 - Modifica o botão para borda arredondada
                    JButton btn = criaBotaoArredondado(texto);

                    if (texto.equals("=")) {
                        gbc.gridheight = 2;
                        gbc.gridy = i;
                        gbc.gridx = j;
                        botoes.add(btn, gbc);
                        gbc.gridheight = 1;
                        // pular a próxima linha pois "=" ocupa 2 linhas
                        break;
                    } else {
                        botoes.add(btn, gbc);
                    }
                }
            }
        }


        
        /*  1.1.25 - Adiciona o painel de botões ao centro da janela
         *      - Adiciona o KeyListener para capturar eventos de teclado
         *      - Permite que a janela receba foco para capturar eventos de teclado
         *      - Solicita foco no painel de botões para capturar eventos de teclado
         *      - Define a janela como visível
         */ 
        add(botoes, BorderLayout.CENTER); 
        addKeyListener(this);  
        setFocusable(true); 
        setVisible(true); 

        // 2.1.25 - foca no campo de texto para capturar eventos de teclado
        requestFocusInWindow(); 
    }
        /*
     * =============================
     * MENU DE CONFIGURAÇÃO
     * =============================
     * 2.1.25 - Adiciona um menu suspenso "Configurações" com opções de tema claro e escuro
     *          - Permite ao usuário alternar entre os temas
     * 
     */
    private void CriarMenu() {
        JMenuBar menuBar = new JMenuBar(); 
        JMenu menuConfiguracoes = new JMenu("Configurações");

        modoClaroItem = new JMenuItem("Tema Claro");
        modoEscuroItem = new JMenuItem("Tema Escuro");
        modoClaroItem.addActionListener (e -> trocarTema(false));
        modoEscuroItem.addActionListener (e -> trocarTema(true));

        menuConfiguracoes.add(modoClaroItem); 
        menuConfiguracoes.add(modoEscuroItem); 
    
        JMenu fonteMenu = new JMenu("Fonte");
        JMenuItem tipoFonte = new JMenuItem("Alterar Tipo");
        JMenuItem tamanhoFonte = new JMenuItem("Alterar Tamanho");

        tipoFonte.addActionListener(e -> {
            String tipo = JOptionPane.showInputDialog(this, "Digite o tipo da fonte");
            if (tipo != null && !tipo.trim().isEmpty()){
                tela.setFont(new Font(tipo, Font.PLAIN, tela.getFont().getSize()));
            }
        });

        tamanhoFonte.addActionListener (e -> {
            String input = JOptionPane.showInputDialog(this, "Digite o tamanho da fonte");
            try {
                int tamanho = Integer.parseInt(input);
                tela.setFont(tela.getFont().deriveFont((float) tamanho));
            } catch (Exception ignored){

            }
        });

        fonteMenu.add(tipoFonte);
        fonteMenu.add(tamanhoFonte);
        menuConfiguracoes.add(fonteMenu);

        menuBar.add(menuConfiguracoes); 
        setJMenuBar(menuBar); 
        atualizarTema();

    }
    
    /*
     * =============================
     * TROCAR TEMA
     * =============================
     * 2.1.25 - Altera para modo escuro ou claro e atualiza o menu
     */

    private void trocarTema(boolean escuro) {
        modoEscuro = escuro;
        Color fundo = escuro ? Color.DARK_GRAY : Color.WHITE;
        Color texto = escuro ? Color.WHITE : Color.BLACK;
        tela.setBackground(fundo);
        tela.setForeground(texto);
        historicoArea.setBackground(fundo);
        historicoArea.setForeground(texto);
        atualizarTema();
    } 
    
    private void atualizarTema() {
        modoClaroItem.setEnabled(modoEscuro); // Desabilita o item de tema claro se o modo escuro estiver ativado
        modoEscuroItem.setEnabled(!modoEscuro); // Desabilita o item de tema escuro se o modo claro estiver ativado
    }

    /*
     * =============================
     * AÇÃO DOS BOTÕES
     * =============================
     * 1.1.25 - Trata clique dos botões e executa operações básicas
     *        - Método que trata os eventos de ação dos botões e teclado
     *        - Ele verifica o comando do botão ou tecla pressionada e executa a ação correspondente
     *        - Obtém o comando do botão ou tecla pressionada
     *        - Funcionamento dos botoes numericos e operacionais
     * 2.1.25 - Adiciona funcionalidade do botão CE e histórico
     */

    @Override
    public void actionPerformed(ActionEvent e){ 
        String comando = e.getActionCommand(); 

        if (comando.matches("[0-9\\.]")){ 
            if (novaEntrada){ 
                tela.setText("");
                novaEntrada = false;
            }
            tela.setText(tela.getText() + comando); 
            
        } else if (comando.matches("[+\\-*/%]")) { 
            primeiroNumero = Double.parseDouble(tela.getText()); 
            operacao = comando; 
            // 2.2.25 - Adiciona a operação ao histórico
            tela.setText("");
            novaEntrada = true; 
        } else if (comando.matches("=")){ 
            double segundoNumero = Double.parseDouble(tela.getText()); 
            double resultado = servicos.calcular(primeiroNumero, segundoNumero, operacao); 
            //2.2.25 - Adiciona o resultado ao histórico
            historicoArea.append(primeiroNumero + " " + operacao + " " + segundoNumero + "\n= " + resultado + "\n\n");
            tela.setText(String.valueOf(resultado)); 
            novaEntrada = true; 
        } else if (comando.matches("C")) { 
            tela.setText(""); 
            primeiroNumero = 0; 
            operacao = ""; 
            novaEntrada = true; 
        } else if (comando.matches("CE")){
            String texto = tela.getText();
            if (!texto.isEmpty()){
                tela.setText(texto.substring(0,texto.length() - 1)); // Remove o último caractere
            }
        }
    }

    /*
     * =============================
     * SUPORTE A TECLADO
     * =============================
     * 1.1.25 - Suporte a números, operações básicas, Enter, ESC
     *        - Método que trata os eventos de pressionamento de tecla
     *        - Ele verifica a tecla pressionada e executa a ação correspondente
     * 2.1.25 - Suporte à tecla Delete e Backspace como CE
     */

    
     @Override
    public void keyPressed(KeyEvent e) { 
        char tecla = e.getKeyChar(); 
        String teclaString = String.valueOf(tecla); 
        if ("0123456789.".contains(teclaString)){ 
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, teclaString)); 
        } else if ("+-*/".contains(teclaString)){ 
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, teclaString)); 
        } else if (tecla == '\n') { 
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "="));
        } else if (tecla == 27 || tecla == 8){ 
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "C"));
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE){
            actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "CE"));
        } else if (tecla == '%') {
            try {
                actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "%"));
            } catch (Exception ex) {
                tela.setText("Erro");
            }
        }
    }


    // 2.3.25 - Modofica o botao para borda arredondada
    private JButton criaBotaoArredondado (String texto){
        JButton botao = new JButton(texto){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2d.setColor(getForeground());
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent()) / 2 - 3;
                g2d.drawString(getText(), x, y);
                g2d.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getForeground());
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
                g2d.dispose();
            }
        };
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setOpaque(false);
        botao.setBorderPainted(false);
        botao.setForeground(Color.BLACK);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.addActionListener(this);
        return botao;
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    
}

