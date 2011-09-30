PR = "r2"

DEPENDS = "task-bug-buildhost"

inherit bug-image

# These are the base system recipes
IMAGE_INSTALL += "task-base-extended \
		task-bug-buildhost \
		task-bug-buildhost-devlangs \
		task-bug-buildhost-network \
		task-bug-buildhost-build \
		bash-sh \
		"
