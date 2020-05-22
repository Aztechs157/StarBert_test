package frc.robot.controllers;

import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj.Joystick;
import java.util.HashMap;
import frc.robot.controllers.ControllerModel.ButtonDef;
import frc.robot.controllers.ControllerModel.AxisDef;

public class ControllerSet {

    // Map of joystick ids to Joysick objects
    private final HashMap<Integer, Joystick> joysticks = new HashMap<>();

    private final ControllerModel[] controllers;
    private int activeController = 0; // The first controller in the list gets active by default

    public ControllerSet(final ControllerModel... controllers) {
        // It doesn't make sense to make a set with no controller
        // The rest of the code makes use of this assumsion
        if (controllers.length < 1) {
            throw new IllegalArgumentException("ControllerSet must have at least one controller!");
        }
        this.controllers = controllers;
    }

    /**
     * Get a joystick or create one if it doesn't exist
     *
     * @param id The joystick id to get or create
     * @return The joystick
     */
    private Joystick getJoystick(final int id) {
        if (!joysticks.containsKey(id)) {
            joysticks.put(id, new Joystick(id));
        }
        return joysticks.get(id);
    }

    /**
     * Get a raw button state from a ButtonDef
     *
     * @param def The button to get the state of
     * @return The state of the button
     */
    public boolean getRawButton(final ButtonDef def) {
        return controllers[activeController].getButton(this::getJoystick, def);
    }

    /**
     * Get a raw axis value from a AxisDef
     *
     * @param def The axis to get the value of
     * @return The value of the axis
     */
    public double getRawAxis(final AxisDef def) {
        return controllers[activeController].getAxis(this::getJoystick, def);
    }

    /**
     * Use multiple ButtonDefs and return the one that's currently active
     *
     * @param defs The ButtonDefs to use
     * @return A wpilib Button object that dynamicly responds to the current active
     */
    public Button useButton(final ButtonDef... defs) {
        return new Button(() -> getRawButton(defs[activeController]));
    }

    /**
     * Use multiple AxisDefs and return the one that's currently active
     *
     * @param defs The AxisDefs to use
     * @return The value of the axis of the currently active controller
     */
    public double useAxis(final AxisDef... defs) {
        return getRawAxis(defs[activeController]);
    }

    /**
     * Change the currently active controller
     *
     * @param newActive The index that the new active controller was passed into
     *                  ControllerSet's constructor
     */
    public void setActive(final int newActive) {
        activeController = newActive;
    }

    public int getActive() {
        return activeController;
    }
}
