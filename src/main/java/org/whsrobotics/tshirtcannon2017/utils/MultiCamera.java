package org.whsrobotics.tshirtcannon2017.utils;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.ArrayList;

/**
 * Helper class for managing multiple USB cameras.
 * TODO: Unsure if Vision Processing would work - it might need specific camera addresses.
 *
 * @author Larry Tseng
 */
public class MultiCamera extends Subsystem {

    public static ArrayList<UsbCamera> cameras;
    private static CameraServer server;

    public final static int X_RESOLUTION = 320;
    public final static int Y_RESOLUTION = 160;
    public final static int FPS = 20;
    public final static int ZERO_EXPOSURE = 0;

    public static MultiCamera instance;

    private MultiCamera(int numberOfCameras) {
        cameras = new ArrayList<>(numberOfCameras);

        System.out.println("Initializing CameraServer...");

        for (int i = 0; i < numberOfCameras; i++) {

            try {
                addCamera();
            } catch (java.lang.Exception ex) {
                System.err.println("Error adding Camera.");
            }

        }
    }

    /**
     * Initialize the default command for a subsystem By default subsystems have no default command,
     * but if they do, the default command is set with this method. It is called on all Subsystems by
     * CommandBase in the users program after all the Subsystems are created.
     */
    @Override
    protected void initDefaultCommand() {

    }

    public static MultiCamera getInstance(int numberOfCameras) {
        if (instance == null) {
            instance = new MultiCamera(numberOfCameras);
        }
        return instance;
    }

    public void addCamera() {
        UsbCamera camera = server.startAutomaticCapture();
        System.out.println("Initializing MultiCamera: " + camera.getName());
        cameras.add(camera);

        setCameraProperties(camera, X_RESOLUTION, Y_RESOLUTION, FPS);
        camera.setExposureAuto();
    }

    public void setCameraProperties(UsbCamera camera, int xResolution, int yResolution, int fps) {
        camera.setResolution(xResolution, yResolution);
        camera.setFPS(fps);
    }

    public void setCameraProperties(int number, int xResolution, int yResolution, int fps) {
        cameras.get(number).setResolution(xResolution, yResolution);
        cameras.get(number).setFPS(fps);
    }

    public void setCameraExposureAuto(int number) {
        cameras.get(number).setExposureAuto();
    }

    public void setCameraExposureManual(int number, int value) {
        cameras.get(number).setExposureManual(value);
    }

}
