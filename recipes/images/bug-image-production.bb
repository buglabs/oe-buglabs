PR = "r14"

DEPENDS = "task-bug task-x11-illume"

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
