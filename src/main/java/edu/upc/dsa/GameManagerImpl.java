package edu.upc.dsa;

import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GameManagerImpl implements GameManager {
    private static GameManager instance;
    protected HashMap<String, User> User;

    HashMap<String, String> Plays = new HashMap<String, String>();
    LinkedList<String> listPlays = new LinkedList<String>();
    LinkedList<User> listUsers = new LinkedList<User>();
    LinkedList<Product> listProducts = new LinkedList<Product>();

    final static Logger logger = Logger.getLogger(GameManagerImpl.class);

    private GameManagerImpl() {
        this.User = new HashMap<>();
    }

    //---------Singletone------------
    public static GameManager getInstance() {
        if (instance == null) instance = new GameManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.User.size();
        logger.info("size " + ret);

        return ret;
    }

    //---------FUNCIONES------------------
    public String createPlay(String id, int N_Team, int P_Players) {
        String status = new Match().getStatus();
        //Comprobar si hay partida iniciada con ese id
        if (listPlays.contains(id)) {
            logger.error("Ya existe este id:" + id);
            status = "NO_INICIADO";
        } else {
            Play playNew = new Play(id, N_Team, P_Players);
            listPlays.add(id);
            logger.info("Se ha creado el juego con" + N_Team + "equipos de" + P_Players + "jugadores.");
            status = "INICIADO_EN_PREPARACIÓN";
        }
        return status;
    }

    //------------ADDUSER-------------------------
    public void addUser(String idUser, String name, String surname, double dsaCoins) {
        User user;
        logger.info("Comprobación de si ya existe un usuario con id: " + idUser);

        if (listUsers.contains(idUser)) {
            logger.error("Ya existe este usuario");
        } else {
            logger.info("Creamos nuevo usuario con id " + idUser);
            user = new User(idUser, name, surname, dsaCoins);
            //Lo añadimos a la lista, ultimo elemento
            listUsers.addLast(user);
        }
        dsaCoins = 25;
        //Monedero del user
        String userCoins = idUser + "/" + dsaCoins;

    }

    //---------------ADDPRODCUT-------------------------
    public void addProduct(String idProduct, String description, double price) {
        Product product;
        logger.info("Comprobamos la existencia del producto con id: " + idProduct);

        if (listProducts.contains(idProduct)) {
            logger.error("Ya existe este producto");
        } else {
            logger.info("Añadimos nuevo producto con id " + idProduct);
            product = new Product(idProduct, description, price);
            //Lo añadimos a la lista, ultimo elemento
            listProducts.addLast(product);
        }
    }

    //---------------BUYPRODUCT------------------
    public void buyProduct(String idUser, String idProduct) {
        logger.info("Comprobamos la existencia del producto y del usuario, con id" + idProduct + "y" + idUser + "respectivamente");

        if (listUsers.contains(idUser) && listProducts.contains(idProduct)) {
            logger.error("Se ha comprado el producto.");
        } else {
            logger.error("No exixte ningún producto ni usuario con ese id");
        }

    }

    //--------------STARTMATCH---------------
    public String startMatch(String idPlay, String idUser) {
        String status = new Match().getStatus();
        boolean start = false;
        //Comprobar q user no esté ya en otra partida
        if (listPlays.contains(idPlay) && listUsers.contains(idUser)) {
            logger.error("El usuario" + idUser + "ha creado una partida con id" + idPlay);
            if (Plays.containsValue(idPlay) && idPlay.equals(Plays.get(idUser))) {
                logger.error("El usuario se encuentra en otra partida.");
            } else {
                status = "INICIADO_EN_FUNCIONAMIENTO";
                start = true;
            }
        } else {
            logger.error("No existe el usuario o la partida");
        }
        if (start) {
            logger.info("Inicio de la partida");
            Plays.put(idPlay, idUser);
        }
        return status;
    }

    //--------------CONSULTSTATUS--------------------
    public String consultStatus(String idPlay) {
        String res = null;
        String status = new Match().getStatus();
        if (listPlays.contains(idPlay)) {
            logger.info("Ya existe una partida con este id" + idPlay);
            res = status;
        } else {
            logger.error("No existe la partida");
        }
        return res;
    }

    //--------------CONSULTLIFE--------------------
    public int consultLife(String idUser) {
        int res = 0;
        if (listUsers.contains(idUser) && Plays.containsKey(idUser)) {
            logger.info("El usuario con te id" + idUser + "se encuentra en una partida");
            int life = new Match().getLife();
            res = life;
        } else {
            logger.info("No existe el usuario o no se encunetra en ninguna partida");
            res = -1;
        }
        return res;
    }

    //-------------FINISHPLAY----------------------
    public String finishPlay(String idPlay) {
        String status = new Match().getStatus();
        if (listPlays.contains(idPlay) && Plays.containsKey(idPlay)) {
            logger.info("Ya existe una partida con este id" + idPlay);
            for (Map.Entry<String, String> entry : Plays.entrySet()) {
                if (entry.getKey().equals(idPlay)) {
                    Plays.remove(idPlay);
                    logger.info("La partida ha finalizado");
                    status = "FINALIZADO";
                    break;
                }
            }
        } else {
            logger.error("No existe ninguna partida iniciada con id" + idPlay);
        }
        return status;
    }
    //------------------------------------
    public int numProducts() {
        return this.listProducts.size();
    }

    @Override
    public int numUsers() {
        return this.listUsers.size();
    }

}

