package proiectpoo.pkg1;

public class Cursanti {

    String user, nume, prenume, parola, email, telefon;
    int id, cursuri, teste, acces ,punctaj;

    public Cursanti(Integer id, String user, String parola, String nume, String prenume, String email, String telefon, Integer teste, int punctaj , int cursuri, Integer acces) {
        this.id = id;
        this.user = user;
        this.parola = parola;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.teste = teste;
        this.punctaj = punctaj;
        this.cursuri = cursuri;
        this.acces = acces;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setUser(String user)
    {
        this.user = user;
    }
    public void setParola(String parola)
    {
        this.parola = parola;
    }
    public void setNume(String nume)
    {
        this.nume = nume;
    }
    public void setPrenume(String prenume)
    {
        this.prenume = prenume;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
    }
    public void setPunctaj(int punctaj)
    {
        this.punctaj=punctaj;
    }
    public void setTeste(int teste)
    {
        this.teste = teste;
    }
    public void setCursuri(int cursuri)
    {
        this.cursuri=cursuri;
    }
    public void setAcces(int acces)
    {
        this.acces = acces;
    }

    public int getId()
    {
        return id;
    }
    public String user()
    {
        return user;
    }
    public String parola()
    {
        return parola;
    }
    public String nume()
    {
        return nume;
    }
    public String prenume()
    {
        return prenume;
    }
    public String email()
    {
        return email;
    }
    public String telefon()
    {
        return telefon;
    }
    public int cursuri()
    {
        return cursuri;
    }
    public int teste()
    {
        return teste;
    }
    public int acces()
    {
        return acces;
    }
}
