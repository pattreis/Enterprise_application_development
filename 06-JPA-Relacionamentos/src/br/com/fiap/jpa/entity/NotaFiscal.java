package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_NOTA_FISCAL")
@SequenceGenerator(name = "nota", sequenceName = "SQ_T_NOTA_FISCAL")
public class NotaFiscal {

	@Id
	@Column(name = "cd_nota_fiscal")
	@GeneratedValue(generator = "nota", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar DATA;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_pedido", nullable = false)
	private Pedido pedido;

	@Column(name = "vl_nota", nullable = false)
	private double valor;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "T_IMPOSTO_NOTA_FISCAL", joinColumns = @JoinColumn(name = "cd_nota_fiscal"), inverseJoinColumns = @JoinColumn(name = "cd_imposto"))
	private List<Imposto> impostos;

	public NotaFiscal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotaFiscal(Calendar dATA, double valor, Pedido pedido) {
		super();
		DATA = dATA;
		this.valor = valor;
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDATA() {
		return DATA;
	}

	public void setDATA(Calendar dATA) {
		DATA = dATA;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Imposto> getImpostos() {
		return impostos;
	}

	public void setImpostos(List<Imposto> impostos) {
		this.impostos = impostos;
	}

}
