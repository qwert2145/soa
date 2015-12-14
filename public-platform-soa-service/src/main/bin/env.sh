CLASS_NAME="com.womai.platform.service.lanucher.Provider"

LOGS_DIR="/opt/logs/soa/platform-soa/"

if [ ! -n "$LOGS_DIR" ]; then
	LOGS_DIR=$DEPLOY_DIR/logs
fi
if [ ! -d $LOGS_DIR ]; then
	mkdir -p $LOGS_DIR
fi

echo $CLASS_NAME $LOGS_DIR