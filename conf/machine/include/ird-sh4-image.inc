do_image_jffs2[depends] += "fup-native:do_populate_sysroot"

do_image_ubi[depends] += "fup-native:do_populate_sysroot"

IMAGE_CMD_jffs2_append = "\
    ; \
    while [ ! -s ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.jffs2 ]; do sleep 1; done ; \
    cp ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.jffs2 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.jffs2; \
    mkdir -p ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}; \
    while [ ! -s ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.jffs2 ]; do sleep 1; done ; \
    mv ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.jffs2 ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${ROOTFS_FILE}; \
    cp ${DEPLOY_DIR_IMAGE}/uImage ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE}; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.zip; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.ird; \
    cd ${DEPLOY_DIR_IMAGE}; \
    fup -ce ${IMAGEDIR}/${IMAGE_NAME}-R${RESELLERID}.ird -r ${IMAGEDIR}/${ROOTFS_FILE} -k ${IMAGEDIR}/${KERNEL_FILE}; \
    fup -r ${IMAGEDIR}/${IMAGE_NAME}-R${RESELLERID}.ird ${RESELLERID}; \
    zip ${IMAGE_NAME}_ird.zip ${IMAGEDIR}/${IMAGE_NAME}-R${RESELLERID}.ird; \
    rm -f ${IMAGEDIR}/*.ird; \
    zip ${IMAGE_NAME}_usb.zip ${IMAGEDIR}/*; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.jffs2; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.manifest; \
    rm -rf ${IMAGEDIR}; \
    "

IMAGE_CMD_ubi_append = "\
    while [ ! -s ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubi ]; do sleep 1; done ; \
    cp ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubi ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubi; \
    mkdir -p ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}; \
    while [ ! -s ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubi ]; do sleep 1; done ; \
    mv ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubi ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${ROOTFS_FILE}; \
    cp ${DEPLOY_DIR_IMAGE}/uImage ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE}; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.zip; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.ird; \
    cd ${DEPLOY_DIR_IMAGE}; \
    fup -ce ${IMAGEDIR}/${IMAGE_NAME}-R${RESELLERID}.ird -r ${IMAGEDIR}/${ROOTFS_FILE} -k ${IMAGEDIR}/${KERNEL_FILE}; \
    fup -r ${IMAGEDIR}/${IMAGE_NAME}-R${RESELLERID}.ird ${RESELLERID}; \
    zip ${IMAGE_NAME}_ird.zip ${IMAGEDIR}/${IMAGE_NAME}-R${RESELLERID}.ird; \
    rm -f ${IMAGEDIR}/*.ird; \
    zip ${IMAGE_NAME}_usb.zip ${IMAGEDIR}/*; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.ubi; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.manifest; \
    rm -rf ${IMAGEDIR}; \
"
