#ErdeSonneMond
import math

f = open('Sonne.txt','w')
f.write("0"+" "+"0")
f.close()

#txt statt dat, damit ich mir die auch angucken kann
f = open('praesensuebung.txt','w')

#Festlegung der Rechenschritte
t = float(0)
tend = float(100.)
dt = float(0.001)

#Sonne im Koordinatenursprung

#Startwerte Erde
xE1 = 1.
yE1 = 0.
vxE1 = 0.
vyE1 = 2*math.pi

#Startwerte Mond (Mond startet bei der Erde)
xM1 = xE1 * 1.002569
yM1 = 0.
vxM1 = 0.
vyM1 = 0.36
mM = 0.01

#Vorberechnungen
GmEmS = vxE1**2+vyE1**2
GmMmS = GmEmS * mM

dt2 = dt**2.

GmEmM = 0.0000000369 * GmEmS * mM

#Berechnung von Schritt 0
xE0 = xE1 - dt * vxE1
yE0 = yE1 - dt * vyE1

xM0 = xM1 - dt * vxM1
yM0 = yM1 - dt * vyM1

#Solange die Rechnung nicht zu Ende ist
while t < tend:
    #1/Abstand^3 Erde-Sonne
    rE3 = 1. / ((xE1**2. + yE1**2.)**(3./2.))
    #1/Abstand^3 Mond-Sone
    rM3 = 1. / ((xM1**2. + yM1**2.)**(3./2.))
    #1/Abstand^3 Erde-Mond
    r3 = 1. / (((xE1-xM1)**2. + (yE1-yM1)**2.)**(3./2.))
    
    #Verlet Erde
    xE2 = 2. * xE1 - xE0 - dt2 * (GmEmS * rE3 * xE1 + GmEmM * r3 * (xE1-xM1))
    yE2 = 2. * yE1 - yE0 - dt2 * (GmEmS * rE3 * yE1 + GmEmM * r3 * (yE1-yM1))
    
    #Verlet Mond
    xM2 = 2. * xM1 - xM0 - dt2 * (GmMmS * rM3 * xM1 + GmEmM * r3 * (xM1-xE1))
    yM2 = 2. * yM1 - yM0 - dt2 * (GmMmS * rM3 * yM1 + GmEmM * r3 * (yM1-yE1))
    
    #Schreiben der Werte in Datei(t, xE(t),yE(t), xM(t), yM(t)
    f.write(str(t)+" "+str(xE1)+" "+str(yE1)+" "+str(xM1)+" "+str(yM1)+"\n")
    
    #Einsetzen der neuen Werte fuer die naechste Berechnung
    xE0 = xE1
    yE0 = yE1
    xE1 = xE2
    yE1 = yE2
    
    xM0 = xM1
    yM0 = yM1
    xM1 = xM2
    yM1 = yM2
    
    t = t + dt
    
f.close()

print("fertig")