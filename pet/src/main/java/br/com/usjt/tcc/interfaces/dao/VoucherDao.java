package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Voucher;

public interface VoucherDao {

	public void adiciona(Voucher voucher);

	public void atualiza(Voucher voucher);

	public List<Voucher> lista();

	public Voucher busca(Long id);
}
