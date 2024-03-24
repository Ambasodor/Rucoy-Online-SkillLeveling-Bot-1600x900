//Code for Perfect Click Rucoy online vampire (red vampires) skill leveling
public class CopyDownFromHereToLastBracer() {
///////////////////////////////////////////////////////////////////////////////////////----start
    Point y = Point.get(646, 260);
    Point x = Point.get(716, 340);
    Point y1 = Point.get(639, 405);
    Point x1 = Point.get(563, 340);

    Point ybattle = Point.get(606, 254);
    Point xbattle = Point.get(754, 354);
    Point y1battle = Point.get(606, 462);
    Point x1battle = Point.get(526, 378);

    Point mana = Point.get(197, 45);
    int manacolor = 12796676;

    Point manapotion = Point.get(53, 560);
    int manapotioncolor = 16032121;

    Point exoust = Point.get(622, 512);
    int exoustcolor = 49859;

    Point reconnect = Point.get(316, 480);
    int reconnectcolor = 789517;

    Point restartcheck = Point.get(1239, 6);
    int restartcheckcolor = 3552823;

    Point reconnectcheck = Point.get(399, 597);
    int reconnectcheckcolor = 789517;

    Point onlinetr = Point.get(92, 569);
    int onlinetrcolor = 14277082;

    Point onlineturn = Point.get(365, 525);
    int onlineturncolor = 16729538;

    Point wand1 = Point.get(1235, 673);
    Point wand2 = Point.get(1150, 679);

    int color = 65536;
    int colorwhite = 789517;
    int battlecolor = 3198414;

    int beforeleave = 0;

    int alivecount = 0;

    int logofftimes = 0;

    boolean exoustb = false;

    boolean yb = false;
    boolean xb = false;
    boolean y1b = false;
    boolean x1b = false;

    boolean yalive = false;
    boolean xalive = false;
    boolean y1alive = false;
    boolean x1alive = false;


    void reconnect() {
        if (getColor(reconnect) == reconnectcolor) {
            click(reconnect);
            while (getColor(restartcheck) != restartcheckcolor) {
                sleep(50);
                if (getColor(restartcheck) == restartcheckcolor) {
                    sleep(60000);
                    turnonlinetraining();
                    sleep(5000);
                    checkforfarm();
                    break;
                }
            }
        }
    }


    void checkforfarm() {
        if (alivecount > 0) {
            alivecount = 0;
        }
        if (getColor(y) == color) {
            yalive = true;
            alivecount += 1;
        } else {
            yalive = false;
        }
        if (getColor(x) == color) {
            xalive = true;
            alivecount += 1;
        } else {
            xalive = false;
        }
        if (getColor(y1) == colorwhite) {
            y1alive = true;
            alivecount += 1;
        } else {
            y1alive = false;
        }
        if (getColor(x1) == color) {
            x1alive = true;
            alivecount += 1;
        } else {
            x1alive = false;
        }

    }

    void turnonlinetraining() {
        if (getColor(restartcheck) == restartcheckcolor) {
            click(restartcheck);
            while (getColor(onlinetr) != onlinetrcolor) {
                sleep(50);
                log("cannot see label");
                if (getColor(onlinetr) == onlinetrcolor) {
                    break;
                }
            }
            click(onlinetr);
            sleep(2000);
            if (getColor(onlineturn) == onlineturncolor) {
                click(onlineturn);
                sleep(500);
                click(restartcheck);
                sleep(1000);
                click(restartcheck);
            } else {
                click(restartcheck);
                sleep(1000);
                click(restartcheck);
            }
        }
    }

    void changewandtokill() {
        if (getColor(ybattle) == battlecolor || getColor(xbattle) == battlecolor || getColor(y1battle) == battlecolor || getColor(x1battle) == battlecolor) {
            click(wand1);
            sleep(500);
            click(wand2);
            while (getColor(ybattle) == battlecolor || getColor(xbattle) == battlecolor || getColor(y1battle) == battlecolor || getColor(x1battle) == battlecolor) {
                sleep(50);
                if (getColor(ybattle) != battlecolor && getColor(xbattle) != battlecolor && getColor(y1battle) != battlecolor && getColor(x1battle) != battlecolor) {
                    click(wand1);
                    sleep(500);
                    click(wand2);
                    break;
                }
            }
        }
    }

    startScreenCapture(2);

    sleep(4000);

    checkforfarm();

    reconnect();

    turnonlinetraining();

    sleep(5000);
        while(!EXIT)

    {
        reconnect();

        if (getColor(y) == color && yalive && !yb) {
            click(y);
            while (getColor(ybattle) != battlecolor) {
                if (getColor(reconnect) == reconnectcolor) {
                    reconnect();
                    break;
                }
                if (getColor(ybattle) == battlecolor || getColor(y) != color) break;
            }
            while (getColor(ybattle) == battlecolor) {
                if (getColor(reconnect) == reconnectcolor) {
                    reconnect();
                    break;
                }
                if (getColor(mana) != manacolor) {
                    click(manapotion);
                }
                if (getColor(exoust) == exoustcolor) {
                    sleep(10000);
                    if (getColor(exoust) == exoustcolor && getColor(ybattle) == battlecolor) {
                        yb = true;
                        beforeleave++;
                        log("" + beforeleave);
                        break;
                    }
                } else if (getColor(exoust) == exoustcolor && getColor(ybattle) != battlecolor) {
                    break;
                }
                if (getColor(ybattle) != battlecolor || yb) break;
            }
        } else if (getColor(x) == color && xalive && !xb) {
            click(x);
            while (getColor(xbattle) != battlecolor) {
                if (getColor(reconnect) == reconnectcolor) {
                    reconnect();
                    break;
                }
                if (getColor(xbattle) == battlecolor || getColor(x) != color) break;
            }
            while (getColor(xbattle) == battlecolor) {
                if (getColor(reconnect) == reconnectcolor) {
                    reconnect();
                    break;
                }
                if (getColor(mana) != manacolor) {
                    click(manapotion);
                }
                if (getColor(exoust) == exoustcolor) {
                    sleep(10000);
                    if (getColor(exoust) == exoustcolor && getColor(xbattle) == battlecolor) {
                        xb = true;
                        beforeleave++;
                        log("" + beforeleave);
                        break;
                    } else if (getColor(exoust) == exoustcolor && getColor(ybattle) != battlecolor) {
                        break;
                    }
                }
                if (getColor(xbattle) != battlecolor || xb) break;
            }
        } else if (getColor(y1) == colorwhite && y1alive && !y1b) {
            click(y1);
            while (getColor(y1battle) != battlecolor) {
                if (getColor(reconnect) == reconnectcolor) {
                    reconnect();
                    break;
                }
                if (getColor(y1battle) == battlecolor || getColor(y1) != colorwhite) break;
            }
            while (getColor(y1battle) == battlecolor) {
                if (getColor(reconnect) == reconnectcolor) {
                    reconnect();
                    break;
                }
                if (getColor(mana) != manacolor) {
                    click(manapotion);
                }
                if (getColor(exoust) == exoustcolor) {
                    sleep(10000);
                    if (getColor(exoust) == exoustcolor && getColor(y1battle) == battlecolor) {
                        y1b = true;
                        beforeleave++;
                        log("" + beforeleave);
                        break;
                    } else if (getColor(exoust) == exoustcolor && getColor(ybattle) != battlecolor) {
                        break;
                    }
                }
                if (getColor(y1battle) != battlecolor || y1b) break;
            }
        } else if (getColor(x1) == color && x1alive && !x1b) {
            click(x1);
            while (getColor(x1battle) != battlecolor) {
                if (getColor(reconnect) == reconnectcolor) {
                    reconnect();
                    break;
                }
                if (getColor(x1battle) == battlecolor || getColor(x1) != color) break;
            }
            while (getColor(x1battle) == battlecolor) {
                if (getColor(reconnect) == reconnectcolor) {
                    reconnect();
                    break;
                }
                if (getColor(mana) != manacolor) {
                    click(manapotion);
                }
                if (getColor(exoust) == exoustcolor) {
                    sleep(10000);
                    if (getColor(exoust) == exoustcolor && getColor(x1battle) == battlecolor) {
                        x1b = true;
                        beforeleave++;
                        log("" + beforeleave);
                        break;
                    } else if (getColor(exoust) == exoustcolor && getColor(ybattle) != battlecolor) {
                        break;
                    }
                }
                if (getColor(x1battle) != battlecolor || x1b) break;
            }
        }

        if (alivecount == beforeleave) {
            if (alivecount != 0) {
                alivecount = 0;
            }
            yb = false;
            xb = false;
            y1b = false;
            x1b = false;
            yalive = false;
            xalive = false;
            y1alive = false;
            x1alive = false;
            beforeleave = 0;
            log("before leave now: " + beforeleave);
            logofftimes += 1;
            log("restart time: " + logofftimes);
            changewandtokill();
            sleep(3000000);
            reconnect();
            turnonlinetraining();
        }

    }

        //////////////////////////////////////////////////////---stop
}
