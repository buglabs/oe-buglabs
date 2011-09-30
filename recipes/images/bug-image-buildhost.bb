PR = "r2"

DEPENDS = "task-bug-buildhost"

inherit bug-image

# These are the base system recipes
IMAGE_INSTALL += "task-base-extended \
		task-bug \
		task-bug-devlangs \
		task-bug-network \
		bash-sh \
		task-bug-build \
		"
