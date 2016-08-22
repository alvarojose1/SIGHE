/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Array;

/**
 *
 * @author Eriberto
 */
public interface ModelDAO {
    public boolean inserir(Object object);
    public boolean excluir(String matricula);
    public boolean editar(Object object);
    public Array getTodos();
}