/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Przemyslaw Swiderski, Adam Gorazda
 */
@Entity
@Table(name = "zdarzenia", catalog = "bazadanych", schema = "")
@NamedQueries(
{
    @NamedQuery(name = "Zdarzenia.findAll", query = "SELECT z FROM Zdarzenia z"),
    @NamedQuery(name = "Zdarzenia.findByIdzdarzenia", query = "SELECT z FROM Zdarzenia z WHERE z.idzdarzenia = :idzdarzenia"),
    @NamedQuery(name = "Zdarzenia.findByData", query = "SELECT z FROM Zdarzenia z WHERE z.data = :data"),
    @NamedQuery(name = "Zdarzenia.findByNazwa", query = "SELECT z FROM Zdarzenia z WHERE z.nazwa = :nazwa"),
    @NamedQuery(name = "Zdarzenia.findByGodzina", query = "SELECT z FROM Zdarzenia z WHERE z.godzina = :godzina")
})
public class Zdarzenia implements Serializable
{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idzdarzenia")
    private Integer idzdarzenia;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "nazwa")
    private String nazwa;
    @Column(name = "godzina")
    private Integer godzina;

    public Zdarzenia()
    {
    }

    public Zdarzenia(Integer idzdarzenia)
    {
        this.idzdarzenia = idzdarzenia;
    }

    public Integer getIdzdarzenia()
    {
        return idzdarzenia;
    }

    public void setIdzdarzenia(Integer idzdarzenia)
    {
        Integer oldIdzdarzenia = this.idzdarzenia;
        this.idzdarzenia = idzdarzenia;
        changeSupport.firePropertyChange("idzdarzenia", oldIdzdarzenia, idzdarzenia);
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public void setNazwa(String nazwa)
    {
        String oldNazwa = this.nazwa;
        this.nazwa = nazwa;
        changeSupport.firePropertyChange("nazwa", oldNazwa, nazwa);
    }

    public Integer getGodzina()
    {
        return godzina;
    }

    public void setGodzina(Integer godzina)
    {
        Integer oldGodzina = this.godzina;
        this.godzina = godzina;
        changeSupport.firePropertyChange("godzina", oldGodzina, godzina);
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idzdarzenia != null ? idzdarzenia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zdarzenia))
        {
            return false;
        }
        Zdarzenia other = (Zdarzenia) object;
        if ((this.idzdarzenia == null && other.idzdarzenia != null) || (this.idzdarzenia != null && !this.idzdarzenia.equals(other.idzdarzenia)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "GUI.Zdarzenia[ idzdarzenia=" + idzdarzenia + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
