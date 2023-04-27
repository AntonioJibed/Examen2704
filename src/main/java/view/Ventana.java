package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.ControladorAsignatura;
import controller.ControladorAsignaturaPorDocente;
import controller.ControladorDocente;
import model.Asignaturaspordocente;
import model.Asignatura;
import model.Docente;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class Ventana extends JPanel {

	private JTextField jtfNombre;
	private static List<Docente> docentes = new ArrayList<Docente>();
	private static JComboBox<Docente> jcbDocente = new JComboBox<Docente>();
	private JList jlistAsignaturasNoS;
	private JList jlistAsignaturasS;
	private DefaultListModel<Asignatura> listModelAsignatura = null;
	private DefaultListModel<Asignatura> listModelAsignatura2 = null;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnGuardar;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private List<Asignatura> asignaturas = ControladorAsignatura.findAll();
	private List<Asignatura> asignaturasParaGuardar = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public Ventana() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 188, 106, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 220, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Docentes y asignaturas");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 0;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				docentes = ControladorDocente.findLikeNombre(jtfNombre.getText());
				rellenarcomboDocentes(docentes);
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 2;
		add(btnFiltrar, gbc_btnFiltrar);

		jcbDocente = new JComboBox();
		GridBagConstraints gbc_jcbDocente = new GridBagConstraints();
		gbc_jcbDocente.insets = new Insets(0, 0, 5, 5);
		gbc_jcbDocente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbDocente.gridx = 0;
		gbc_jcbDocente.gridy = 3;
		add(jcbDocente, gbc_jcbDocente);

		JButton btnCargarMaterias = new JButton("Cargar Materias");
		btnCargarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarAsignaturas();
			}
		});
		GridBagConstraints gbc_btnCargarMaterias = new GridBagConstraints();
		gbc_btnCargarMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarMaterias.gridx = 1;
		gbc_btnCargarMaterias.gridy = 3;
		add(btnCargarMaterias, gbc_btnCargarMaterias);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 247, 135, 293, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblAlumnadoNoSeleccionado = new JLabel("Asignaturas no seleccionadas");
		GridBagConstraints gbc_lblAlumnadoNoSeleccionado = new GridBagConstraints();
		gbc_lblAlumnadoNoSeleccionado.gridwidth = 2;
		gbc_lblAlumnadoNoSeleccionado.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlumnadoNoSeleccionado.gridx = 0;
		gbc_lblAlumnadoNoSeleccionado.gridy = 0;
		panel.add(lblAlumnadoNoSeleccionado, gbc_lblAlumnadoNoSeleccionado);

		JLabel lblAlumnadoSeleccionado = new JLabel("Asignaturas seleccionadas");
		GridBagConstraints gbc_lblAlumnadoSeleccionado = new GridBagConstraints();
		gbc_lblAlumnadoSeleccionado.insets = new Insets(0, 0, 5, 0);
		gbc_lblAlumnadoSeleccionado.gridx = 2;
		gbc_lblAlumnadoSeleccionado.gridy = 0;
		panel.add(lblAlumnadoSeleccionado, gbc_lblAlumnadoSeleccionado);

		jlistAsignaturasNoS = new JList(this.getDefaultListModel());
		jlistAsignaturasNoS.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		jlistAsignaturasS = new JList(this.getDefaultListModel2());
		jlistAsignaturasS.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		scrollPane = new JScrollPane(jlistAsignaturasNoS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		button = new JButton("<<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTodo2();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_1.add(button, gbc_button);

		button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSeleccionados2();
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		panel_1.add(button_1, gbc_button_1);

		button_2 = new JButton(">");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSeleccionados();
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 2;
		panel_1.add(button_2, gbc_button_2);

		button_3 = new JButton(">>");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTodo();
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 3;
		panel_1.add(button_3, gbc_button_3);

		scrollPane_1 = new JScrollPane(jlistAsignaturasS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 5;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 7;
		gbc_btnGuardar.gridy = 0;
		panel_2.add(btnGuardar, gbc_btnGuardar);

	}

	public static void rellenarcomboDocentes(List<Docente> municipios) {
		limpiarDocentes();

		for (Docente docente : docentes) {
			jcbDocente.addItem(docente);
		}
	}

	public static void limpiarDocentes() {
		jcbDocente.removeAllItems();
	}

	private void cambiarSeleccionados() {
		List<Asignatura> l = jlistAsignaturasNoS.getSelectedValuesList();
		this.listModelAsignatura2.addAll(l);
		for (int i = this.jlistAsignaturasNoS.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelAsignatura.removeElementAt(this.jlistAsignaturasNoS.getSelectedIndices()[i]);
		}
	}

	private void cambiarSeleccionados2() {
		this.listModelAsignatura.addAll(jlistAsignaturasS.getSelectedValuesList());
		for (int i = this.jlistAsignaturasS.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelAsignatura2.removeElementAt(this.jlistAsignaturasS.getSelectedIndices()[i]);
		}
	}

	private void cambiarTodo() {
		listModelAsignatura.removeAllElements();
		listModelAsignatura2.removeAllElements();
		listModelAsignatura2.addAll(asignaturas);

	}

	private void cambiarTodo2() {
		listModelAsignatura2.removeAllElements();
		listModelAsignatura.removeAllElements();
		listModelAsignatura.addAll(asignaturas);

	}

	private DefaultListModel getDefaultListModel2() {
		this.listModelAsignatura2 = new DefaultListModel<Asignatura>();
		return this.listModelAsignatura2;
	}

	private DefaultListModel getDefaultListModel() {
		this.listModelAsignatura = new DefaultListModel<Asignatura>();
		return this.listModelAsignatura;
	}

	private void agregarAsignaturas() {
		listModelAsignatura.removeAllElements();
		listModelAsignatura.addAll(asignaturas);

	}

	private void guardar() {

		for (int i = 0; i < listModelAsignatura2.size(); i++) {
			asignaturasParaGuardar.add(listModelAsignatura2.getElementAt(i));
		}
		for (Asignatura asignatura : asignaturasParaGuardar) {
			Asignaturaspordocente apd = ControladorAsignaturaPorDocente.asignaturaDocente(asignatura,
					(Docente) jcbDocente.getSelectedItem());
			if (apd != null) {
				ControladorAsignaturaPorDocente.update(apd);
			} else {
				apd = new Asignaturaspordocente();
				apd.setAsignatura(asignatura);
				apd.setDocente((Docente) jcbDocente.getSelectedItem());
				ControladorAsignaturaPorDocente.insert(apd);
			}

		}
	}
}
