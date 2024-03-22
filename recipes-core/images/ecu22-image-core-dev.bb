# ECU22 development image
DESCRIPTION = "ECU22 development image"

require ecu22-image-core.bb

## Select development image features
IMAGE_FEATURES += " \
    dev-pkgs \
    debug-tweaks \
    tools-profile \
"
