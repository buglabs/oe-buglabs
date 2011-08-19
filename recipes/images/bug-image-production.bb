PR = "r13"

DEPENDS = "task-bug task-x11-illume"
IMAGE_FEATURES += "apps-console-core"

inherit bug-image

# These are the base system recipes
IMAGE_INSTALL += "task-base-extended \
		task-bug \
		task-bug-java-osgi \
		task-bug-audio \
		task-bug-x11 \
		task-bug-devlangs \
		task-bug-network \
		task-bug-e17 \
		bash-sh \
		task-bug-debug \
		task-bug-docs \
		"
